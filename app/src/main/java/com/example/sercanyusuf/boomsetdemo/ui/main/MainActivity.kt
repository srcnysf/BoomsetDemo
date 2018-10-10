package com.example.sercanyusuf.boomsetdemo.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.ui.events.EventFragment
import com.example.sercanyusuf.boomsetdemo.util.SaveSharedPreference
import com.example.sercanyusuf.boomsetdemoapp.ui.base.BaseActivity
import com.example.sercanyusuf.boomsetdemoapp.ui.login.LoginActivity


class MainActivity : BaseActivity() {

    private var mEventFragment: EventFragment = EventFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isNetworkConnected

        if (SaveSharedPreference.getLoggedStatus(applicationContext)) {
            setFragments()
        }
        else{
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
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
}
