package com.gkpoter.customer.activity

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.ListView
import android.widget.Toast
import com.gkpoter.customer.R
import com.gkpoter.customer.activity.adapter.DialogAdapter
import com.gkpoter.customer.activity.adapter.HomeAdapter
import com.gkpoter.customer.bean.HomeBean
import com.gkpoter.customer.bean.HomeItemBean
import com.gkpoter.customer.interfaze.OnShopChangeListener
import com.gkpoter.customer.presenter.HomePresent
import com.gkpoter.customer.utils.FinishListActivity
import com.gkpoter.customer.view.IHomeView

class HomeActivity : AppCompatActivity(), IHomeView {

    private val homePresent = HomePresent(this)
    private val item = ArrayList<HomeItemBean>()
    private var adapter: HomeAdapter? = null
    private var listener: OnShopChangeListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        FinishListActivity.getInstance().addActivity(this)
        init()
        homePresent.showData()

        findViewById<FloatingActionButton>(R.id.shop).setOnClickListener {
            homePresent.showDialog()
        }
    }

    private fun init() {
        listener = object : OnShopChangeListener {
            override fun change(clazz: String, itemBean: HomeItemBean) {
                for (homeItemBean in item) {
                    if (homeItemBean.name == itemBean.name) {
                        item.remove(homeItemBean)
                        break
                    }
                }
                item.add(itemBean)
            }
        }
    }

    override fun upData(): List<HomeItemBean> {
        return item
    }

    override fun showData(data: List<HomeBean>) {
        adapter = HomeAdapter(data, this, listener!!)
        val list = findViewById<ExpandableListView>(R.id.homelist)
        list.setGroupIndicator(null)
        list.setAdapter(adapter)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showDialog() {
        val builder = AlertDialog.Builder(this);
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_content, null)
        val list = view.findViewById<ListView>(R.id.home_dialog_list)
        val commit = view.findViewById<Button>(R.id.home_dialog_c)
        val back = view.findViewById<Button>(R.id.home_dialog_b)
        val alert = builder.setView(view).show()
        list.adapter = DialogAdapter(item, this)
        back.setOnClickListener {
            alert.dismiss()
        }
        commit.setOnClickListener {
            homePresent.upData()
        }
    }

    override fun onBackPressed() {
        FinishListActivity.getInstance().exit()
    }

}