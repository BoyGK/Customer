package com.gkpoter.customer.activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.Button
import android.widget.TextView
import com.gkpoter.customer.R
import com.gkpoter.customer.bean.HomeBean
import com.gkpoter.customer.bean.HomeItemBean
import com.gkpoter.customer.interfaze.OnShopChangeListener

/**
 * Created by "GKpoter" on 2017/9/18.
 */
class HomeAdapter(val data: List<HomeBean>, val context: Context, val listener: OnShopChangeListener)
    : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return data.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return data[groupPosition].item.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return data[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return data[groupPosition].item[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, view: View?, parent: ViewGroup): View {
        var view = view
        var parentHolder: ParentHolder? = null
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_parent, null)
            parentHolder = ParentHolder()
            /**
             * 添加子view
             */
            parentHolder.clazz = view!!.findViewById(R.id.clazz)
            view!!.tag = parentHolder
        } else {
            parentHolder = view.tag as ParentHolder
        }
        parentHolder.clazz!!.text = data[groupPosition].clazz
        return view
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, view: View?, parent: ViewGroup): View {
        var view = view
        var childHolder: ChildHolder? = null
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_children, null)
            childHolder = ChildHolder()
            /**
             * 添加子view
             */
            childHolder.name = view!!.findViewById(R.id.name)
            childHolder.price = view!!.findViewById(R.id.price)
            childHolder.unit = view!!.findViewById(R.id.unit)
            childHolder.number = view!!.findViewById(R.id.number)
            childHolder.add = view!!.findViewById(R.id.add)
            childHolder.sub = view!!.findViewById(R.id.sub)
            view!!.tag = childHolder
        } else {
            childHolder = view.tag as ChildHolder
        }
        childHolder.name!!.text = data[groupPosition].item[childPosition].name
        childHolder.price!!.text = "价格:" + data[groupPosition].item[childPosition].price
        childHolder.unit!!.text = " " + data[groupPosition].item[childPosition].unit
        childHolder.number!!.text = data[groupPosition].item[childPosition].number.toString()
        childHolder.add!!.setOnClickListener {
            var add_ = Integer.parseInt(childHolder!!.number!!.text.toString())
            childHolder!!.number!!.text = (add_ + 1).toString()
            listener.change(data[groupPosition].clazz, itemBean = HomeItemBean(
                    childHolder!!.name!!.text as String,
                    childHolder!!.price!!.text!!.toString().replace("价格:", "").toFloat(),
                    childHolder!!.unit!!.text as String,
                    add_ + 1))
        }
        childHolder.sub!!.setOnClickListener {
            var sub_ = Integer.parseInt(childHolder!!.number!!.text.toString())
            childHolder!!.number!!.text = if (sub_ - 1 > 0) (sub_ - 1).toString() else 0.toString()
            listener.change(data[groupPosition].clazz, itemBean = HomeItemBean(
                    childHolder!!.name!!.text as String,
                    childHolder!!.price!!.text!!.toString().replace("价格:", "").toFloat(),
                    childHolder!!.unit!!.text as String,
                    if (sub_ - 1 > 0) (sub_ - 1) else 0))
        }
        return view
    }

    inner class ParentHolder {
        var clazz: TextView? = null
    }

    inner class ChildHolder {
        var name: TextView? = null
        var price: TextView? = null
        var unit: TextView? = null
        var number: TextView? = null
        var sub: Button? = null
        var add: Button? = null
    }
}