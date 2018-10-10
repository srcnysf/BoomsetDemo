package com.example.sercanyusuf.boomsetdemoapp.ui.login

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.ui.login.LoginPresenter
import com.example.sercanyusuf.boomsetdemo.ui.login.LoginView
import com.example.sercanyusuf.boomsetdemo.ui.main.MainActivity
import com.example.sercanyusuf.boomsetdemo.util.SaveSharedPreference
import com.example.sercanyusuf.boomsetdemoapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject





class LoginActivity : BaseActivity(), LoginView {


    @Inject
    internal lateinit var mLoginPresenter: LoginPresenter

    var mUsername: String? = null
    var mPassword: String? = null
    var usernameText: EditText? = null
    var passwordText: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLoginPresenter = LoginPresenter()
        mLoginPresenter.setView(this)

        usernameText = this.findViewById(R.id.email)
        passwordText = this.findViewById(R.id.password)

        email_sign_in_button.setOnClickListener {
            login()
        }
    }

    override fun login() {
        mUsername = usernameText!!.text.toString()
        mPassword = passwordText!!.text.toString()
        if (mLoginPresenter.isEmailAndPasswordValid(mUsername!!, mPassword!!)) {
            //showWaitingDialog()
            hideKeyboard()
            mLoginPresenter.login(mUsername!!, mPassword!!)
        } else {
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onLoginSuccessful() {
        //dismissWaitingDialog()
        SaveSharedPreference.setLoggedIn(applicationContext, true)
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}


