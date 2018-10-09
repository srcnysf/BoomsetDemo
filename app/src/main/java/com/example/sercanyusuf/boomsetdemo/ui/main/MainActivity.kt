package com.example.sercanyusuf.boomsetdemo.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.ui.events.EventFragment
import com.example.sercanyusuf.boomsetdemoapp.ui.base.BaseActivity


class MainActivity : BaseActivity() {

    private var mEventFragment: EventFragment = EventFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isNetworkConnected
        setFragments()

    }

    private fun setFragments() {
        val mFragmentTransaction = supportFragmentManager.beginTransaction()
        mFragmentTransaction.add(R.id.home_content_frame, mEventFragment)
        mFragmentTransaction.commit()
    }

    fun switchFragment(fragment: Fragment) {
        if (!isFinishing && !isDestroyed) {
            val mFragmentTransaction = supportFragmentManager.beginTransaction()
            mFragmentTransaction.setCustomAnimations(
                    R.anim.enter_from_right_animation, R.anim.exit_from_right_animation,
                    R.anim.enter_from_left_animation, R.anim.exit_from_left_animation)
            mFragmentTransaction.replace(R.id.home_content_frame, fragment)
                    .addToBackStack(null).commit()
        }
    }


    fun backToFragment(fragment: Fragment) {
        if (!isFinishing && !isDestroyed) {
            val mFragmentTransaction = supportFragmentManager.beginTransaction()
            mFragmentTransaction.setCustomAnimations(
                    R.anim.enter_from_left_animation, R.anim.exit_from_left_animation,
                    R.anim.enter_from_right_animation, R.anim.exit_from_right_animation)
            mFragmentTransaction.replace(R.id.home_content_frame, fragment)
                    .addToBackStack(null).commit()
        }
    }

    fun switchToSettingsFragment(fragmentManager: android.support.v4.app.FragmentManager) {
        val mFragTransaction = fragmentManager.beginTransaction()
        mFragTransaction.setCustomAnimations(
                R.anim.enter_from_top_animation,R.anim.exit_from_top_animation,
                R.anim.enter_from_bottom,R.anim.exit_from_bottom)
        mFragTransaction
                .replace(R.id.home_content_frame, mEventFragment)
                .addToBackStack("Settings Fragment")
                .commit()
    }
}
