package com.gkpoter.customer.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gkpoter.customer.R
import com.gkpoter.customer.presenter.LoginPresent
import com.gkpoter.customer.utils.FinishListActivity
import com.gkpoter.customer.view.ILoginView

class LoginActivity : AppCompatActivity(), ILoginView {

    private val loginPresent = LoginPresent(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        FinishListActivity.getInstance().addActivity(this)

        initView()
    }

    private fun initView() {
        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            loginPresent.login()
        }
    }

    override fun getUserName(): String {
        val username = findViewById<EditText>(R.id.username)
        return username.text.toString()
    }

    override fun getPassWord(): String {
        val password = findViewById<EditText>(R.id.password)
        return password.text.toString()
    }

    override fun startHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun showLoginErrorMessage() {
        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show()
    }

    override fun clearEditText() {
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        username.setText("")
        password.setText("")
    }

    override fun onBackPressed() {
        loginPresent.exit()
    }
}
