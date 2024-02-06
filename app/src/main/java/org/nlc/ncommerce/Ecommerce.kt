package org.nlc.ncommerce

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class Ecommerce : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}