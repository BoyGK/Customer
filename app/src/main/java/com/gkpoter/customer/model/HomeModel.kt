package com.gkpoter.customer.model

import com.gkpoter.customer.app.App
import com.gkpoter.customer.bean.BaseBean
import com.gkpoter.customer.bean.HomeBean
import com.gkpoter.customer.bean.HomeItemBean
import com.gkpoter.customer.bean.HomeModule
import com.gkpoter.customer.interfaze.MyCallBack
import com.gkpoter.customer.interfaze.OnGetHomeDataListener
import com.gkpoter.customer.interfaze.OnUpDataListener
import com.gkpoter.customer.utils.DataUtils
import com.gkpoter.customer.utils.HttpUtils
import com.google.gson.Gson
import org.xutils.common.Callback

/**
 * Created by "GKpoter" on 2017/9/18.
 */
class HomeModel : IHomeModel {
    override fun getData(listener: OnGetHomeDataListener) {
        val homeBeans = ArrayList<HomeBean>()
        for (i in 0..14) {
            val itemBeans = ArrayList<HomeItemBean>()
            for (j in 0..9) {
                val itemBean = HomeItemBean("萝卜" + j, 2.5.toFloat(), "/斤",0)
                itemBeans.add(itemBean)
            }
            val homeBean = HomeBean("蔬菜", itemBeans)
            homeBeans.add(homeBean)
        }
        listener.onSuccess(homeBeans)
//        for test
//        val map = HashMap<String, String>()
//        map.put("key", "3113")
//        HttpUtils.Get("getall", map, object : MyCallBack<String> {
//            override fun onSuccess(result: String) {
//                val data = Gson().fromJson(result, HomeModule::class.java)
//                if (data.state == 1) {
//                    listener.onSuccess(data.data)
//                } else {
//                    listener.onError(data.msg)
//                }
//            }
//
//            override fun onError(ex: Throwable, isOnCallback: Boolean) {
//            }
//
//            override fun onCancelled(cex: Callback.CancelledException) {
//            }
//
//            override fun onFinished() {
//            }
//
//        })
    }

    override fun upData(data: List<HomeItemBean>, listener: OnUpDataListener) {
        val map = HashMap<String, Any>()
        val user = DataUtils("user", App.getAppContext())
        map.put("username", user.getData("username", ""))
        map.put("data", data)
        HttpUtils.Post("updata", map, object : MyCallBack<String> {
            override fun onSuccess(result: String) {
                val re = Gson().fromJson(result, BaseBean::class.java)
                if (re.state == 1) {
                    listener.onSuccess(re.msg)
                } else {
                    listener.onError(re.msg)
                }
            }

            override fun onError(ex: Throwable, isOnCallback: Boolean) {
            }

            override fun onCancelled(cex: Callback.CancelledException) {
            }

            override fun onFinished() {
            }

        })
    }

}