package com.gkpoter.customer.activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.gkpoter.customer.R
import com.gkpoter.customer.bean.HomeItemBean

/**
 * Created by "GKpoter" on 2017/9/19.
 */
class DialogAdapter(val data: List<HomeItemBean>, val context: Context) : BaseAdapter() {

    override fun getView(position: Int, view: View?, p2: ViewGroup?): View {
        var view = view
        view = LayoutInflater.from(context).inflate(R.layout.item_dialog, null)
        val name = view.findViewById<TextView>(R.id.d_name)
        val price = view.findViewById<TextView>(R.id.d_price)
        val number = view.findViewById<TextView>(R.id.d_num)
        name.text = "物品:" + data[position].name
        price.text = "单价:" + data[position].price
        number.text = "数量:" + data[position].number
        return view
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}