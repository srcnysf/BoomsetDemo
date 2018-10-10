package com.example.sercanyusuf.boomsetdemoapp.ui.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.sercanyusuf.boomsetdemo.ui.base.BaseView
import com.example.sercanyusuf.boomsetdemo.util.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*


open class BaseActivity : AppCompatActivity(), BaseView {

    val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(applicationContext)

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun showWaitingDialog() {
        pb.visibility = View.VISIBLE
    }

    override fun dismissWaitingDialog() {
        pb.visibility = View.GONE
    }

    override fun showErrorMessage(returnCode: Int, message: String) {
    }


}
