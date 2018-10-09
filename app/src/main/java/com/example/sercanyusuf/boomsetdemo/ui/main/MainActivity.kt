package com.example.sercanyusuf.boomsetdemo.ui.main

import android.os.Bundle
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


}
