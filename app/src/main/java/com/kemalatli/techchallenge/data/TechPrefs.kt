package com.kemalatli.techchallenge.data

import android.content.Context

class TechPrefs(private val context:Context) {

    private val sharedPrefs by lazy { context.getSharedPreferences("tech_challenge", Context.MODE_PRIVATE) }

    /**
     * Persist login state to shared preferences
     */
    fun persistLogin(){
        sharedPrefs.edit().putBoolean("loggedIn", true).apply()
    }

    /**
     * Remove any data related to login state
     */
    fun deleteLogin(){
        sharedPrefs.edit().remove("loggedIn").apply()
    }

    /**
     * Retrieve login state
     */
    val isLogged:Boolean get() {
        return sharedPrefs.getBoolean("loggedIn", false)
    }

}