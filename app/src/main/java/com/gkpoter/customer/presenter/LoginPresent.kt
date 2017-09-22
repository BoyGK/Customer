package com.gkpoter.customer.presenter

import com.gkpoter.customer.bean.UserBean
import com.gkpoter.customer.interfaze.OnLoginListener
import com.gkpoter.customer.model.LoginModel
import com.gkpoter.customer.view.ILoginView

/**
 * Created by "GKpoter" on 2017/9/18.
 */
class LoginPresent(val loginView: ILoginView) {

    private val loginModel = LoginModel()

    fun login() {
        loginModel.login(loginView.getUserName(), loginView.getPassWord(), object : OnLoginListener {
            override fun onSuccess(user: UserBean) {
                loginView.startHomeActivity()
            }

            override fun onError(msg: String) {
                loginView.showLoginErrorMessage()
                loginView.clearEditText()
            }

        })
    }

    fun exit(){
        loginModel.exit()
    }
}