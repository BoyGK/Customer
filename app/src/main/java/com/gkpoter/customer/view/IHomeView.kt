package com.gkpoter.customer.view

import com.gkpoter.customer.bean.HomeBean
import com.gkpoter.customer.bean.HomeItemBean

/**
 * Created by "GKpoter" on 2017/9/18.
 */
interface IHomeView {

    /**
     * get data from server
     */
    fun upData(): List<HomeItemBean>


    /**
     * up data to server
     */
    fun showData(data: List<HomeBean>)

    /**
     *
     */
    fun showMessage(msg: String)

    /**
     *
     */
    fun showDialog()
}