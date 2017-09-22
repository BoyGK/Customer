package com.gkpoter.customer.bean

/**
 * Created by "GKpoter" on 2017/9/18.
 */
/**
 * default response
 */
data class BaseBean(val state: Int, val msg: String)

/**
 * user login request
 */
data class UserBean(val username: String, val password: String)

/**
 * homepage request & response
 */
data class HomeItemBean(val name: String, val price: Float, val unit: String, var number: Int)

data class HomeBean(val clazz: String, val item: List<HomeItemBean>)

data class HomeModule(val state: Int, val msg: String, val data: List<HomeBean>)