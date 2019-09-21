package com.kemalatli.techchallenge.features.login

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

    /**
     * Login with [LoginState.username] and [LoginState.password]
     */
    fun login() = setState {
        val status = loginRepository.login(username, password, rememberMe)
        copy(status = status)
    }

    /**
     * Logout and clear [LoginState.status]
     */
    fun logout() = setState {
        // Wipe out persisted auth state
        loginRepository.logout()
        // Null status routes application to login fragment.
        // This is done via subscription to login state in MainActivity
        copy(status = null, rememberMe = false)
    }


    companion object:MvRxViewModelFactory<LoginViewModel, LoginState>{
        override fun create(viewModelContext: ViewModelContext, state: LoginState): LoginViewModel? {
            val loginRepository:LoginRepository by viewModelContext.activity.inject()
            return LoginViewModel(state, loginRepository)
        }
    }

}