package com.kemalatli.techchallenge.data

import android.content.Context

class TechPrefs(private val context:Context) {

    private val sharedPrefs by lazy { context.getSharedPreferences("tech_challenge", Context.MODE_PRIVATE) }

    fun persistLogin(){
        sharedPrefs.edit().putBoolean("loggedIn", true).apply()
    }

    fun deleteLogin(){
        sharedPrefs.edit().remove("loggedIn").apply()
    }

    val isLogged:Boolean get() {
        return sharedPrefs.getBoolean("loggedIn", false)
    }

}