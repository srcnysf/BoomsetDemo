package com.example.sercanyusuf.boomsetdemo.ui.main

import android.content.Intent
import android.os.Bundle
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemoapp.ui.base.BaseActivity
import com.example.sercanyusuf.boomsetdemoapp.ui.login.LoginActivity


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isNetworkConnected

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }



}
