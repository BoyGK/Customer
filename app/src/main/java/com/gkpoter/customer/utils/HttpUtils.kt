package com.gkpoter.customer.utils

/**
 * Created by "GKpoter" on 2017/9/21.
 */
import org.xutils.common.Callback
import org.xutils.http.RequestParams
import org.xutils.x

/**
 * Created by "GKpoter" on 2017/7/3.
 */

object HttpUtils {

    private val URL = "http://www.baiguoqing.com:8080/"

    /**
     * 发送get请求
     *
     * @param <T>
    </T> */
    fun <T> Get(url: String, map: Map<String, String>?, callback: Callback.CommonCallback<T>): Callback.Cancelable {
        val params = RequestParams(URL + url)
        if (null != map) {
            for ((key, value) in map) {
                params.addQueryStringParameter(key, value)
            }
        }
        return x.http().get(params, callback)
    }

    /**
     * 发送post请求
     *
     * @param <T>
    </T> */
    fun <T> Post(url: String, map: Map<String, Any>?, callback: Callback.CommonCallback<T>): Callback.Cancelable {
        val params = RequestParams(URL + url)
        if (null != map) {
            for ((key, value) in map) {
                params.addParameter(key, value)
            }
        }
        return x.http().post(params, callback)
    }


    /**
     * 上传文件
     *
     * @param <T>
    </T> */
    fun <T> UpLoadFile(url: String, map: Map<String, Any>?, callback: Callback.CommonCallback<T>): Callback.Cancelable {
        val params = RequestParams(URL + url)
        if (null != map) {
            for ((key, value) in map) {
                params.addParameter(key, value)
            }
        }
        params.isMultipart = true
        return x.http().post(params, callback)
    }

    /**
     * 下载文件
     *
     * @param <T>
    </T> */
    fun <T> DownLoadFile(url: String, filepath: String, callback: Callback.CommonCallback<T>): Callback.Cancelable {
        val params = RequestParams(URL + url)
        //设置断点续传
        params.isAutoResume = true
        params.saveFilePath = filepath
        return x.http().get(params, callback)
    }
}
