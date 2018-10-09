package com.example.sercanyusuf.boomsetdemoapp.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.example.sercanyusuf.boomsetdemo.ui.base.BaseView
import com.example.sercanyusuf.boomsetdemo.util.NetworkUtils

open class BaseActivity : AppCompatActivity(), BaseView {
    internal var mProgressDialog: ProgressDialog? = null

    val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(applicationContext)

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun showWaitingDialog() {
    }

    override fun dismissWaitingDialog() {
    }

    override fun showErrorMessage(returnCode: Int, message: String) {
    }




}
