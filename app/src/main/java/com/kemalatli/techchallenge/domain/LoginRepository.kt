package com.kemalatli.techchallenge.domain

import com.kemalatli.techchallenge.base.data.Status

interface LoginRepository {

    fun logout()
    fun login(username:String, password:String, rememberCredentials:Boolean):Status<Boolean>
    fun isLoggedIn():Boolean

}