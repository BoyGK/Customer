package com.gkpoter.customer.model

import com.gkpoter.customer.interfaze.OnLoginListener

/**
 * Created by "GKpoter" on 2017/9/18.
 */
interface ILoginModel {
    /**
     * User Login
     */
    fun login(username: String, password: String, listener: OnLoginListener)

    /**
     * User Logout
     */
    fun exit()
}