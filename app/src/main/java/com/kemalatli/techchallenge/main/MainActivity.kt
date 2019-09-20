package com.kemalatli.techchallenge.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kemalatli.techchallenge.R
import com.kemalatli.techchallenge.features.login.LoginFragment

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set main view
        setContentView(R.layout.activity_main)
        // Add login fragment
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer ,LoginFragment()).commit()
    }

}