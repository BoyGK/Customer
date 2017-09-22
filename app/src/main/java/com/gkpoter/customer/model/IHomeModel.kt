package com.gkpoter.customer.model

import com.gkpoter.customer.bean.HomeItemBean
import com.gkpoter.customer.interfaze.OnGetHomeDataListener
import com.gkpoter.customer.interfaze.OnUpDataListener

/**
 * Created by "GKpoter" on 2017/9/18.
 */
interface IHomeModel {

    /**
     * get all data from server
     */
    fun getData(listener: OnGetHomeDataListener)

    /**
     * up data to server
     */
    fun upData(data: List<HomeItemBean>, listener: OnUpDataListener)

}