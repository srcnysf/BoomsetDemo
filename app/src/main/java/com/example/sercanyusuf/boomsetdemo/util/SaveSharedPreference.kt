package com.example.sercanyusuf.boomsetdemo.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import com.example.sercanyusuf.boomsetdemo.util.AppConstants.LOGGED_IN_PREF

object SaveSharedPreference {

    private fun getPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setLoggedIn(context: Context, loggedIn: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(LOGGED_IN_PREF, loggedIn)
        editor.apply()
    }

    fun getLoggedStatus(context: Context): Boolean {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false)
    }
}