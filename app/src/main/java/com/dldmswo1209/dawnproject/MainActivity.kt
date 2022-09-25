package com.dldmswo1209.dawnproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.LikeMenuFragment.LikeProductFragment
import com.dldmswo1209.dawnproject.MainMenuFragment.HomeFragment
import com.dldmswo1209.dawnproject.databinding.ActivityMainBinding
import com.dldmswo1209.dawnproject.myPage.MyPageFragment
import com.dldmswo1209.dawnproject.topMenuFragment.LikeTopBarFragment
import com.dldmswo1209.dawnproject.topMenuFragment.MainTopBarFragment
import com.dldmswo1209.dawnproject.topMenuFragment.MainTopFragment
import com.dldmswo1209.dawnproject.topMenuFragment.MyPageTopBarFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mainTopBarFragment: MainTopBarFragment
    private lateinit var likeTopBarFragment: LikeTopBarFragment
    private lateinit var myPageTopBarFragment: MyPageTopBarFragment
    private lateinit var myPageFragment: MyPageFragment
    private lateinit var mainTopFragment: MainTopFragment
    private lateinit var homeFragment: HomeFragment
    var isMotionAnimating = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragment()
        bottomNavigationViewItemSelectedListener()

        binding.topMotionLayout.setTransitionListener(object: MotionLayout.TransitionListener{
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
            ) {
                isMotionAnimating = true
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float,
            ) {}

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                isMotionAnimating = false
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float,
            ) {}

        })
    }
    fun startMotion(){
        binding.topMotionLayout.transitionToEnd()
    }
    fun endMotion(){
        binding.topMotionLayout.transitionToStart()
    }


    private fun initFragment(){
        mainTopBarFragment = MainTopBarFragment()
        likeTopBarFragment = LikeTopBarFragment()
        myPageTopBarFragment = MyPageTopBarFragment()
        myPageFragment = MyPageFragment()
        mainTopFragment = MainTopFragment()
        homeFragment = HomeFragment()

        topFragmentReplace(mainTopFragment)
        mainTopFragmentReplace(mainTopBarFragment)
    }

    private fun bottomNavigationViewItemSelectedListener(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    topFragmentReplace(mainTopFragment)
                    topFragmentShow()
                    otherTopFragmentHide(likeTopBarFragment)
                    otherTopFragmentHide(myPageTopBarFragment)
                    mainTopFragmentShow()
                    mainFragmentReplace(homeFragment)
                }
                R.id.category -> {
                    topFragmentReplace(mainTopFragment)
                    topFragmentShow()
                    otherTopFragmentHide(likeTopBarFragment)
                    otherTopFragmentHide(myPageTopBarFragment)
                    mainTopFragmentShow()
                    mainFragmentReplace(homeFragment)
                }
                R.id.avatar -> startActivity(Intent(this, AvatarActivity::class.java))
                R.id.like -> {
                    otherTopFragmentReplace(likeTopBarFragment)
                    otherTopFragmentShow(likeTopBarFragment)
                    mainFragmentReplace(LikeProductFragment())
                    mainTopFragmentHide()
                    topFragmentHide()
                }
                R.id.myPage -> {
                    otherTopFragmentReplace(myPageTopBarFragment)
                    otherTopFragmentShow(myPageTopBarFragment)
                    mainFragmentReplace(myPageFragment)
                    mainTopFragmentHide()
                    topFragmentHide()
                }
            }
            true
        }
    }
    fun otherTopFragmentReplace(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.otherTopContainerView, fragment)
            .commit()
    }
    fun otherTopFragmentHide(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .hide(fragment)
            .commit()
    }
    fun otherTopFragmentShow(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .show(fragment)
            .commit()
    }

    fun topFragmentReplace(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.homeTopContainerView, fragment)
            .commit()
    }
    fun topFragmentHide(){
        supportFragmentManager.beginTransaction()
            .hide(mainTopFragment)
            .commit()
    }
    fun topFragmentShow(){
        supportFragmentManager.beginTransaction()
            .show(mainTopFragment)
            .commit()
    }


    fun mainTopFragmentReplace(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.topTabContainerView, fragment)
            .commit()
    }
    fun mainTopFragmentShow(){
        supportFragmentManager.beginTransaction()
            .show(mainTopBarFragment)
            .commit()
    }

    fun mainTopFragmentHide(){
        supportFragmentManager.beginTransaction()
            .hide(mainTopBarFragment)
            .commit()
    }

    fun mainFragmentReplace(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainerView, fragment)
            .commit()
    }

    override fun onResume() {
        super.onResume()

        binding.bottomNavigationView.selectedItemId = R.id.home
    }


}