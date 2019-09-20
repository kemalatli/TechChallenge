package com.kemalatli.techchallenge.main

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.BaseMvRxActivity
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.viewModel
import com.kemalatli.techchallenge.R
import com.kemalatli.techchallenge.base.data.Status
import com.kemalatli.techchallenge.base.extensions.toast
import com.kemalatli.techchallenge.features.login.LoginFragment
import com.kemalatli.techchallenge.features.login.LoginState
import com.kemalatli.techchallenge.features.login.LoginViewModel
import com.kemalatli.techchallenge.features.order.OrdersFragment

class MainActivity: BaseMvRxActivity() {

    private val loginViewModel:LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set main view
        setContentView(R.layout.activity_main)
        // Listen to auth state
        loginViewModel.selectSubscribe(this, LoginState::status){
            when(it){
                is Status.Success -> navigateTo(OrdersFragment())
                is Status.Failed -> toast(it.message)
                else ->  navigateTo(LoginFragment())
            }
        }
    }

    private fun navigateTo(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer ,fragment).commit()
    }

}