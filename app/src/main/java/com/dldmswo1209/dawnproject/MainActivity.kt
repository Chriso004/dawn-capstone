package com.dldmswo1209.dawnproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.databinding.ActivityMainBinding
import com.dldmswo1209.dawnproject.myPage.MyPageFragment
import com.dldmswo1209.dawnproject.topMenuFragment.LikeTopBarFragment
import com.dldmswo1209.dawnproject.topMenuFragment.MainTopBarFragment
import com.dldmswo1209.dawnproject.topMenuFragment.MyPageTopBarFragment

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
                R.id.avatar -> startActivity(Intent(this, AvatarActivity::class.java))
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

    override fun onResume() {
        super.onResume()

        binding.bottomNavigationView.selectedItemId = R.id.home
    }


}