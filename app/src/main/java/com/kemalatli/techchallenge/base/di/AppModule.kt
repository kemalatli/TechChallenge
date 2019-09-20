package com.kemalatli.techchallenge.base.di

import com.kemalatli.techchallenge.data.LoginRepositoryImpl
import com.kemalatli.techchallenge.data.TechPrefs
import com.kemalatli.techchallenge.domain.LoginRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module{


    single { TechPrefs(androidContext()) }

    single<LoginRepository> { LoginRepositoryImpl(get()) }


}