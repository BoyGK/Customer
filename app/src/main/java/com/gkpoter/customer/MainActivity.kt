package com.gkpoter.customer

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gkpoter.customer.activity.LoginActivity
import com.gkpoter.customer.utils.FinishListActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FinishListActivity.getInstance().addActivity(this)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
            }
        }, 1500)
    }
}
