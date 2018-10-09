package com.example.sercanyusuf.boomsetdemo.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.sercanyusuf.boomsetdemoapp.ui.base.BaseActivity

open class BaseFragment : Fragment(), BaseView {

    protected var mActivity: BaseActivity? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view!!, savedInstanceState)

    }


    override fun showWaitingDialog() {
        mActivity?.let { it.showWaitingDialog() }
    }

    override fun dismissWaitingDialog() {
        mActivity?.let { it.dismissWaitingDialog() }

    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            mActivity = context
        }
        if (mActivity == null) {
            throw  Exception()
        }
    }

    override fun showErrorMessage(returnCode: Int, message: String) {
    }


}