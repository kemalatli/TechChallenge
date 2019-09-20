package com.kemalatli.techchallenge.features.login

import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.PersistState
import com.kemalatli.techchallenge.base.data.Status

data class LoginState(

    @PersistState
    var username:String = "",
    @PersistState
    var password:String = "",
    // Login operation status
    val status:Status<Boolean>? = null

):MvRxState{

    val isUsernameEmpty get() = username.isBlank()
    val isPasswordEmpty get() = password.isBlank()
    val isSuccessfulLogin get() = (username=="kariyer" && password=="2019ADev")

}