package com.example.android.covid_19_stay_alert

import android.app.Application
import timber.log.Timber

class CovidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}