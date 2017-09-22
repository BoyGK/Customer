package com.gkpoter.customer.app

import android.app.Application

/**
 * Created by "GKpoter" on 2017/9/21.
 */
class AppLocation : Application() {

    override fun onCreate() {
        super.onCreate()
        App.init(applicationContext)
    }
}