package com.dldmswo1209.dawnproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.databinding.ActivityMainBinding
import com.dldmswo1209.dawnproject.myPage.MyPageFragment
import com.dldmswo1209.dawnproject.topFragment.LikeTopBarFragment
import com.dldmswo1209.dawnproject.topFragment.MainTopBarFragment
import com.dldmswo1209.dawnproject.topFragment.MyPageTopBarFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mainTopBarFragment: MainTopBarFragment
    private lateinit var likeTopBarFragment: LikeTopBarFragment
    private lateinit var myPageTopBarFragment: MyPageTopBarFragment
    private lateinit var myPageFragment: MyPageFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragment()
        bottomNavigationViewItemSelectedListener()

    }
    private fun initFragment(){
        mainTopBarFragment = MainTopBarFragment()
        likeTopBarFragment = LikeTopBarFragment()
        myPageTopBarFragment = MyPageTopBarFragment()
        myPageFragment = MyPageFragment()
        topFragmentReplace(mainTopBarFragment)
    }

    private fun bottomNavigationViewItemSelectedListener(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> topFragmentReplace(mainTopBarFragment)
                R.id.category -> topFragmentReplace(mainTopBarFragment)
                R.id.avatar -> topFragmentReplace(mainTopBarFragment)
                R.id.like -> topFragmentReplace(likeTopBarFragment)
                R.id.myPage -> {
                    topFragmentReplace(myPageTopBarFragment)
                    mainFragmentReplace(myPageFragment)
                }
            }
            true
        }
    }
    fun topFragmentReplace(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.topContainerView, fragment)
            .commit()
    }
    fun mainFragmentReplace(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainerView, fragment)
            .commit()
    }

}