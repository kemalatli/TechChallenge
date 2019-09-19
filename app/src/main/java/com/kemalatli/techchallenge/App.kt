package com.kemalatli.techchallenge

import android.app.Application
import com.kemalatli.techchallenge.base.di.appModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize Koin dependency tree
        startKoin {
            // Add logger
            androidLogger()
            // Add modules
            modules(appModule)
        }
    }

}