package com.example.sercanyusuf.boomsetdemo.ui.base

interface BaseView {

    fun showWaitingDialog()

    fun dismissWaitingDialog()

    fun showErrorMessage(returnCode: Int, message: String)

}
