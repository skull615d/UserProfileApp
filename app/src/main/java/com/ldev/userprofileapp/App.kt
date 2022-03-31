package com.ldev.userprofileapp

import android.app.Application
import com.ldev.userprofileapp.di.appModule
import com.ldev.userprofileapp.feature.profile.di.profileModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                appModule,
                profileModule
            )
        }
    }
}