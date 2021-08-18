package com.think4software.smtfusioncalculator.core

import android.app.Application
import com.think4software.smtfusioncalculator.di.databaseModules
import com.think4software.smtfusioncalculator.di.useCaseModules
import com.think4software.smtfusioncalculator.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                databaseModules,
                useCaseModules,
                viewModelModules
            )
        }
    }
}