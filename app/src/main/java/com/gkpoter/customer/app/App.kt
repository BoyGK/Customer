package com.gkpoter.customer.app

import android.content.Context

/**
 * Created by "GKpoter" on 2017/9/21.
 */
object App {

    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    fun getAppContext(): Context {
        return context
    }

}