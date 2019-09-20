package com.kemalatli.techchallenge.features.login

import com.kemalatli.techchallenge.base.data.Status
import com.kemalatli.techchallenge.base.viewmodel.BaseViewModel

class LoginViewModel(state:LoginState): BaseViewModel<LoginState>(state) {

    fun login() = setState {
        // Check if username is valid
        if(isUsernameEmpty){
            return@setState copy(status = Status.Failed("Lütfen kullanıcı adınızı giriniz."))
        }
        // Check if username is valid
        if(isPasswordEmpty){
            return@setState copy(status = Status.Failed("Lütfen şifrenizi giriniz."))
        }
        // Check if login is successful
        if(isSuccessfulLogin){
            return@setState copy(status = Status.Success(true))
        }else{
            return@setState copy(status = Status.Failed("Kullanıcı adı veya şifre yanlış."))
        }
    }

}