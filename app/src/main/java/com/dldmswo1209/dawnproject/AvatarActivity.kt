package com.dldmswo1209.dawnproject

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.dldmswo1209.dawnproject.databinding.ActivityAvatarBinding
import com.dldmswo1209.dawnproject.databinding.ActivityMainBinding
import com.google.ar.sceneform.math.Quaternion
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

class AvatarActivity : AppCompatActivity() {
    private var downX = 0f
    private var downY = 0f
    private var xAngle = 0f
    private var yAngle = 0f
    private var lastXAngle = 0f
    private var lastYAngle = 0f
    private val binding by lazy {
        ActivityAvatarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.avatarSceneView.setTransparent(true)
        loadModel()
    }
    @SuppressLint("ClickableViewAccessibility")
    private fun loadModel(){
        val avatar = ModelRenderable
            .builder()
            .setSource(
                this, Uri.parse("models/model_5.glb")
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
                    val modelNode = com.google.ar.sceneform.Node()
                    modelNode.renderable = avatar.get()
                    modelNode.localScale = Vector3(0.1f, 0.1f, 0.1f)
                    modelNode.localRotation = Quaternion.axisAngle(
                        Vector3(0f, 1f, 0f),
                        0f
                    )
                    modelNode.localPosition = Vector3(0f, 0f, -1f)
                    binding.avatarSceneView.scene.addChild(modelNode)

                    binding.avatarSceneView.setOnTouchListener { hitTestResult, motionEvent ->
                        if(motionEvent.action == MotionEvent.ACTION_DOWN){
                            downX = motionEvent.x
                            downY = motionEvent.y

                        }else if(motionEvent.action == MotionEvent.ACTION_MOVE){
                            if(abs(motionEvent.x - downX) > 40 || abs(motionEvent.y - downY) > 40){
                                var x: Float = motionEvent.x - downX
                                var y: Float = motionEvent.y - downY

                                var percentX: Float = x / binding.avatarSceneView.width * 0.6f
                                var percentY: Float = y / binding.avatarSceneView.height * 0.6f

                                xAngle = percentX * 360 * 0.52f + lastXAngle
                                yAngle = percentY * 360 * 0.52f + lastYAngle

                                var xQuaternion = Quaternion.axisAngle(Vector3(0f,1f,0f), xAngle)
                                var yQuaternion = Quaternion.axisAngle(
                                    Vector3(
                                        cos(Math.toRadians(xAngle.toDouble())).toFloat(),
                                        0f,
                                        sin(Math.toRadians(xAngle.toDouble())).toFloat()
                                    ), yAngle
                                )
                                modelNode.localRotation = Quaternion.multiply(xQuaternion, yQuaternion)

                            }


                        }else if(motionEvent.action == MotionEvent.ACTION_UP){
                            lastXAngle = xAngle
                            lastYAngle = yAngle
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