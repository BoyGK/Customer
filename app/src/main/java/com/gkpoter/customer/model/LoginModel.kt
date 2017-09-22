package com.gkpoter.customer.model

import com.gkpoter.customer.bean.UserBean
import com.gkpoter.customer.interfaze.OnLoginListener
import com.gkpoter.customer.utils.FinishListActivity


/**
 * Created by "GKpoter" on 2017/9/18.
 */
class LoginModel : ILoginModel {
    override fun login(username: String, password: String, listener: OnLoginListener) {
//        val map = HashMap<String, Any>()
//        map.put("username", username)
//        map.put("password", password)
//        HttpUtils.Post("login", map, object : MyCallBack<String> {
//            override fun onSuccess(result: String) {
//                val re = Gson().fromJson(result, BaseBean::class.java)
//                if (re.state == 1) {
//                    val save = DataUtils("user", App.getAppContext())
//                    save.saveData("username", username)
//                    save.saveData("password", password)
//                    listener.onSuccess(user = UserBean(username, password))
//                } else {
//                    listener.onError(re.msg)
//                }
//            }
//
//            override fun onError(ex: Throwable, isOnCallback: Boolean) {
//                listener.onError(ex.localizedMessage)
//            }
//
//            override fun onCancelled(cex: Callback.CancelledException) {
//            }
//
//            override fun onFinished() {
//            }
//
//        })
//      fro test
        listener.onSuccess(user = UserBean(username, password))
    }

    override fun exit() {
        FinishListActivity.getInstance().exit()
    }
}