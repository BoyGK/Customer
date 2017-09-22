package com.gkpoter.customer.interfaze

import com.gkpoter.customer.bean.HomeBean
import com.gkpoter.customer.bean.HomeItemBean
import com.gkpoter.customer.bean.UserBean
import org.xutils.common.Callback
import org.xutils.common.Callback.CancelledException
import org.xutils.common.Callback.CommonCallback



/**
 * Created by "GKpoter" on 2017/9/18.
 */

/**
 * Login interface
 */
interface OnLoginListener {
    fun onSuccess(user: UserBean)
    fun onError(msg: String)
}

/**
 * get Data
 */
interface OnGetHomeDataListener {
    fun onSuccess(data: List<HomeBean>)
    fun onError(msg: String)
}

/**
 * up Data
 */
interface OnUpDataListener {
    fun onSuccess(msg: String)
    fun onError(msg: String)
}

/**
 * shop call from adapter to activity
 */
interface OnShopChangeListener {
    fun change(clazz: String, itemBean: HomeItemBean)
}


/**
 * http request
 */
interface MyCallBack<ResultType> : Callback.CommonCallback<ResultType> {

    override fun onSuccess(result: ResultType)
    //可以根据公司的需求进行统一的请求成功的逻辑处理

    override fun onError(ex: Throwable, isOnCallback: Boolean)
    //可以根据公司的需求进行统一的请求网络失败的逻辑处理

    override fun onCancelled(cex: CancelledException)

    override fun onFinished()


}