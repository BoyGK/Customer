package com.gkpoter.customer.presenter

import com.gkpoter.customer.bean.HomeBean
import com.gkpoter.customer.bean.HomeItemBean
import com.gkpoter.customer.interfaze.OnGetHomeDataListener
import com.gkpoter.customer.interfaze.OnUpDataListener
import com.gkpoter.customer.model.HomeModel
import com.gkpoter.customer.view.IHomeView

/**
 * Created by "GKpoter" on 2017/9/18.
 */
class HomePresent(val homeView: IHomeView) {

    private val homeModel = HomeModel()

    fun showData() {
        homeModel.getData(object : OnGetHomeDataListener {
            override fun onSuccess(data: List<HomeBean>) {
                homeView.showData(data)
            }

            override fun onError(msg: String) {
                homeView.showMessage(msg)
            }

        })
    }

    fun upData() {
        homeModel.upData(homeView.upData(), object : OnUpDataListener {
            override fun onSuccess(msg: String) {
                homeView.showMessage(msg)
            }

            override fun onError(msg: String) {
                homeView.showMessage(msg)
            }
        })
    }

    fun showDialog() {
        homeView.showDialog()
    }

}