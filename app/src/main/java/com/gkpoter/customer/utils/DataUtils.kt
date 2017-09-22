package com.gkpoter.customer.utils

import android.app.Activity
import android.content.Context


/**
 * Created by "GKpoter" on 2017/9/21.
 */
class DataUtils(val documation: String, val context: Context) {

    fun saveData(name: String, obj: String) {
        val mySharedPreferences = context.getSharedPreferences(documation, Activity.MODE_PRIVATE)
        //实例化SharedPreferences.Editor对象（第二步）
        val editor = mySharedPreferences.edit()
        //用putString的方法保存数据
        editor.putString(name, obj)
        //提交当前数据
        editor.commit()
    }

    fun getData(name: String, Ex: String): String {
        //同样，在读取SharedPreferences数据前要实例化出一个SharedPreferences对象
        val sharedPreferences = context.getSharedPreferences(documation, Activity.MODE_PRIVATE)
        // 使用getString方法获得value，注意第2个参数是value的默认值
        return sharedPreferences.getString(name, Ex)
    }

    fun clearData() {
        val mySharedPreferences = context.getSharedPreferences(documation, Activity.MODE_PRIVATE)
        //实例化SharedPreferences.Editor对象（第二步）
        val editor = mySharedPreferences.edit()
        editor.clear()
        editor.commit()
    }

}
