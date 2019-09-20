package com.kemalatli.techchallenge.features.login

import android.os.AsyncTask
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.kemalatli.techchallenge.base.data.Status
import com.kemalatli.techchallenge.base.viewmodel.BaseViewModel
import com.kemalatli.techchallenge.domain.LoginRepository
import org.koin.android.ext.android.inject

class LoginViewModel(state:LoginState, private val loginRepository: LoginRepository): BaseViewModel<LoginState>(state) {

    init {
        val initialStatus = if(loginRepository.isLoggedIn()) Status.Success(true) else null
        setState { copy(status=initialStatus) }
    }

    fun login() = setState {
        val status = loginRepository.login(username, password, rememberMe)
        copy(status = status)
    }

    fun logout() = setState {
        loginRepository.logout()
        copy(status = null)
    }


    companion object:MvRxViewModelFactory<LoginViewModel, LoginState>{
        override fun create(viewModelContext: ViewModelContext, state: LoginState): LoginViewModel? {
            val loginRepository:LoginRepository by viewModelContext.activity.inject()
            return LoginViewModel(state, loginRepository)
        }
    }

}