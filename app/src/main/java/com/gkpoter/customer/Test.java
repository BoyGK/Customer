package com.gkpoter.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.gkpoter.customer.bean.HomeBean;
import com.gkpoter.customer.bean.HomeItemBean;
import com.gkpoter.customer.interfaze.OnShopChangeListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "GKpoter" on 2017/9/18.
 */
public class Test extends BaseExpandableListAdapter {

    private List<HomeBean> data;
    private Context context;

    public Test(List<HomeBean> dates, Context context) {
        this.data = dates;
        this.context = context;
        Integer.parseInt("123");
        int a = 1 > 2 ? 1 : 2;

        List<HomeBean> homeBeans = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            List<HomeItemBean> itemBeans = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                HomeItemBean itemBean = new HomeItemBean("萝卜", (float) 2.5,"", 0);
                itemBeans.add(itemBean);
            }

            for (HomeItemBean itemBean : itemBeans) {
                if(true) {
                    itemBeans.remove(itemBean);
                    break;
                }
            }
            HomeBean homeBean = new HomeBean("蔬菜", itemBeans);
            homeBeans.add(homeBean);
        }

    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getItem().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getItem().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        ParentHolder parentHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_parent, null);
            parentHolder = new ParentHolder();
            /**
             * 添加子view
             */

            view.setTag(parentHolder);
        } else {
            parentHolder = (ParentHolder) view.getTag();
        }

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_children, null);
            childHolder = new ChildHolder();
            /**
             * 添加子view
             */

            view.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) view.getTag();
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ParentHolder {

    }

    class ChildHolder {

    }
}
