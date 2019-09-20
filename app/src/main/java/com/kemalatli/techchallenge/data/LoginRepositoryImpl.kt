package com.kemalatli.techchallenge.data

import com.kemalatli.techchallenge.base.data.Status
import com.kemalatli.techchallenge.domain.LoginRepository

class LoginRepositoryImpl(private val techPrefs: TechPrefs):LoginRepository {

    override fun logout() = techPrefs.deleteLogin()

    override fun isLoggedIn(): Boolean = techPrefs.isLogged

    override fun login(username: String, password: String, rememberCredentials: Boolean): Status<Boolean> {
        // Check if username is valid
        if(username.isBlank()){
            return Status.Failed("Lütfen kullanıcı adınızı giriniz.")
        }
        // Check if username is valid
        if(password.isBlank()){
            return Status.Failed("Lütfen şifrenizi giriniz.")
        }
        // Check if login is successful
        return if(username=="kariyer" && password=="2019ADev"){
            // Persist logged in state so that login screen can be skipped in the next launch
            if(rememberCredentials) techPrefs.persistLogin()
            Status.Success(true)
        }else{
            Status.Failed("Kullanıcı adı veya şifre yanlış.")
        }
    }


}