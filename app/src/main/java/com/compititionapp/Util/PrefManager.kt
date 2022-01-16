package com.compititionapp.Util

import android.content.Context
import android.content.Intent
import com.compititionapp.home_screen.HomeScreenActivity
import com.compititionapp.login.ui.login.LoginActivity


class PrefManager {

    var context: Context? = null

    // Sharedpref file name
    private val PREF_NAME = "PrefManager"

    // All Shared Preferences Keys
    private val IS_LOGIN = "IsLoggedIn"

    // User name (make variable public to access from outside)
    val KEY_NAME = "username"

    // Email address (make variable public to access from outside)
    val KEY_ID = "_iD"

    fun PrefManager(context: Context?) {
        this.context = context
    }

    fun getInt(key: String?): Int? {
        val sharedPreferences = context!!.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        return sharedPreferences.getInt(key, 0)
    }
    fun getString(key: String?): String? {
        val sharedPreferences = context!!.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, null)
    }
    fun getBoolean(key: String?): Boolean {
        val sharedPreferences = context!!.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(key, false)
    }
    fun putInt(key: String?, num: Int) {
        val sharedPreferences =
            context!!.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor =  sharedPreferences.edit()
        editor.remove(key)
        editor.putInt(key, num)
        editor.commit() // IF commit() showing warning then use apply() instead .
        editor.apply()
    }

    fun putString(key: String?, value:String?) {
        val sharedPreferences = context!!.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor =  sharedPreferences.edit()
        editor.putString(key, value)
        editor.commit() // IF commit() showing warning then use apply() instead .
        editor.apply()
    }

    fun putBoolean(key: String?, value:Boolean) {
        val sharedPreferences = context!!.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor =  sharedPreferences.edit()
        editor.remove(key)
        editor.putBoolean(key, value)
        editor.commit() // IF commit() showing warning then use apply() instead .
        editor.apply()
    }


    /**
     * Create login session
     */
    fun createLoginSession(username:String?,userID: String?) { // Storing login value as TRUE
        val sharedPreferences = context!!.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor =  sharedPreferences.edit()

        editor.putBoolean(IS_LOGIN, true)
        // Storing name in pref
        editor.putString(KEY_ID, userID)
        // Storing email in pref
        editor.putString(KEY_NAME, username)
        // commit changes
        editor.commit()
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    fun checkLogin() { // Check login status
        if (!isLoggedIn()) { // user is not logged in redirect him to Login Activity
            val i = Intent(context, LoginActivity::class.java)
            // Closing all the Activities
            //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            // Add new Flag to start new Activity
            //i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            // Staring Login Activity
            context!!.startActivity(i)
        }else{
            val i = Intent(context, HomeScreenActivity::class.java)
            context!!.startActivity(i)
        }
    }


   /* *//**
     * Get stored session data
     *//*
    fun getUserDetails(): HashMap<String, String?> {
        val pref = context!!.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val user = HashMap<String, String?>()
        // user name
        user[KEY_NAME] = pref.getString(KEY_NAME, null)
        // user email id
        user[KEY_EMAIL] = pref.getString(KEY_EMAIL, null)
        // return user
        return user
    }*/

    /**
     * Clear session details
     */
    fun logoutUser() { // Clearing all data from Shared Preferences
        val sharedPreferences = context!!.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor =  sharedPreferences.edit()
        editor.clear()
        editor.apply()

    }

    /**
     * Quick check for login
     */
// Get Login State
    fun isLoggedIn(): Boolean {
        val pref = context!!.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return pref.getBoolean(IS_LOGIN, false)
    }

    fun clear(key: String){
        val sharedPreferences = context!!.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor =  sharedPreferences.edit()
        editor.putString(key,"")
        editor.remove(key)
        editor.clear()
        editor.apply()
    }
}