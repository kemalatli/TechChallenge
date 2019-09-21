package com.kemalatli.techchallenge.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.BaseMvRxActivity
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
                is Status.Failed -> toast(it.message)
                is Status.Success -> navigateTo(OrdersFragment())
                else ->  navigateTo(LoginFragment())
            }
        }
    }

    /**
     * Route navigation requests to support fragment manager.
     */
    private fun navigateTo(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(R.id.mainContainer ,fragment)
            .commit()
    }

}