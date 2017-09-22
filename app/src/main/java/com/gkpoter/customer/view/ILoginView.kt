package com.gkpoter.customer.view

/**
 * Created by "GKpoter" on 2017/9/18.
 */
interface ILoginView {
    /**
     * get UserName & PassWord
     */
    fun getUserName(): String

    fun getPassWord(): String

    /**
     * Login success : startActivity
     */
    fun startHomeActivity()

    /**
     * Login error : Toast LoginError Message
     */
    fun showLoginErrorMessage()

    /**
     * Login error : clear EditText
     */
    fun clearEditText()
}