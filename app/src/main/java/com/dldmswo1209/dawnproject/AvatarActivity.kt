package com.dldmswo1209.dawnproject

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.dldmswo1209.dawnproject.databinding.ActivityAvatarBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.math.Quaternion
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import kotlinx.coroutines.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import kotlin.math.abs


class AvatarActivity : AppCompatActivity() {
    private var downX = 0f
    private var xAngle = 0f
    private var lastXAngle = 0f
    private val binding by lazy {
        ActivityAvatarBinding.inflate(layoutInflater)
    }

    private val nodeList = mutableListOf<Node>()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.avatarSceneView.setTransparent(true)

        loadModel("models/basic1.glb")

        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                async {
                    loadModel("models/basic3.glb")
                    delay(200)
                }.await()

                nodeList.firstOrNull {
                    binding.avatarSceneView.scene.removeChild(it)
                    nodeList.removeFirst()
                    true
                }
            }
        }
        binding.button2.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                async {
                    loadModel("models/basic2.glb")
                    delay(200)
                }.await()

                nodeList.firstOrNull {
                    binding.avatarSceneView.scene.removeChild(it)
                    nodeList.removeFirst()
                    true
                }
            }
        }

        val behavior = BottomSheetBehavior.from(binding.persistentBottomSheet)
        behavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED-> {
                        val bottomMargin = dpToPx(this@AvatarActivity, 100f).toInt()

                        val margin =
                            CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
                                CoordinatorLayout.LayoutParams.MATCH_PARENT)
                        margin.setMargins(0, 0, 0, bottomMargin)
                        binding.avatarSceneView.layoutParams = margin


                    }

                    BottomSheetBehavior.STATE_EXPANDED-> {

                        val bottomMargin = dpToPx(this@AvatarActivity, 250f).toInt()
                        val margin =
                            CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
                                CoordinatorLayout.LayoutParams.MATCH_PARENT)
                        margin.setMargins(0, 0, 0, bottomMargin)
                        binding.avatarSceneView.layoutParams = margin

                    }

                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("testt", slideOffset.toString())
                val bottomMarginFloat = (slideOffset * 150) + 100
                val bottomMargin = dpToPx(this@AvatarActivity, bottomMarginFloat).toInt()

                val margin =
                    CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
                        CoordinatorLayout.LayoutParams.MATCH_PARENT)
                margin.setMargins(0, 0, 0, bottomMargin)
                binding.avatarSceneView.layoutParams = margin

            }

        })
    }
    fun dpToPx(context: Context, dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun loadModel(path: String){
        val avatar = ModelRenderable
            .builder()
            .setSource(
                this, Uri.parse(path)
            )
            .setIsFilamentGltf(true)
            .setAsyncLoadEnabled(true)
            .build()

        val backdrop = ModelRenderable
            .builder()
            .setSource(
                this, Uri.parse("models/backdrop.glb")
            )
            .setIsFilamentGltf(true)
            .setAsyncLoadEnabled(true)
            .build()

        CompletableFuture.allOf(avatar, backdrop)
            .handle<Any?>{ok: Void?, ex: Throwable? ->
                try{
                    val modelNode = Node()
                    modelNode.renderable = avatar.get()
                    modelNode.localScale = Vector3(0.1f, 0.1f, 0.1f)
                    modelNode.localRotation = Quaternion.axisAngle(
                        Vector3(0f, 1f, 0f),
                        0f
                    )
                    modelNode.localPosition = Vector3(0f, -0.1f, -0.12f)
                    binding.avatarSceneView.scene.addChild(modelNode)
                    nodeList.add(modelNode)

                    binding.avatarSceneView.setOnTouchListener { hitTestResult, motionEvent ->
                        if(motionEvent.action == MotionEvent.ACTION_DOWN){
                            downX = motionEvent.x

                        }else if(motionEvent.action == MotionEvent.ACTION_MOVE){
                            if(abs(motionEvent.x - downX) > 40){
                                var x: Float = motionEvent.x - downX
                                var percentX: Float = x / binding.avatarSceneView.width * 0.6f

                                xAngle = percentX * 360 * 0.52f + lastXAngle

                                var xQuaternion = Quaternion.axisAngle(Vector3(0f,1f,0f), xAngle)
                                var yQuaternion = Quaternion.axisAngle(Vector3(0f, 0f, 0f), 0f
                                )
                                modelNode.localRotation = Quaternion.multiply(xQuaternion, yQuaternion)
                            }

                        }else if(motionEvent.action == MotionEvent.ACTION_UP){
                            lastXAngle = xAngle
                        }

                        true
                    }
                }catch (ignore: InterruptedException){
                }catch (ignore: ExecutionException){}
                null
            }
    }
    
    override fun onResume() {
        super.onResume()
        binding.avatarSceneView.resume()
    }

    override fun onPause() {
        super.onPause()
        binding.avatarSceneView.pause()
    }

}