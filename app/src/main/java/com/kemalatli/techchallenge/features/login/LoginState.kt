package com.kemalatli.techchallenge.features.login

import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.PersistState
import com.kemalatli.techchallenge.base.data.Status

data class LoginState(

    @PersistState
    var username:String = "",

    @PersistState
    var password:String = "",

    @PersistState
    var rememberMe:Boolean = false,

    // Login operation status
    val status:Status<Boolean>? = null


):MvRxState