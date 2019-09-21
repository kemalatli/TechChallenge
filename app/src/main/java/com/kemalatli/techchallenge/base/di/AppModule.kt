package com.kemalatli.techchallenge.base.di

import com.kemalatli.techchallenge.data.LoginRepositoryImpl
import com.kemalatli.techchallenge.data.OrdersRepositoryImpl
import com.kemalatli.techchallenge.data.TechPrefs
import com.kemalatli.techchallenge.domain.LoginRepository
import com.kemalatli.techchallenge.domain.OrdersRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module{

    // OkHttp Client
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("http://kariyertechchallenge.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .addCallAdapterFactory((RxJava2CallAdapterFactory.create()))
            .build()
    }

    // Shared preferences to persist login state
    single { TechPrefs(androidContext()) }

    // Login repository
    single<LoginRepository> { LoginRepositoryImpl(get()) }

    // Order repository
    single<OrdersRepository> { OrdersRepositoryImpl(get()) }


}