package com.ogieben.gad

import android.app.Application
import com.ogieben.gad.di.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@App)
//            modules(appModule)
//        }
    }
}