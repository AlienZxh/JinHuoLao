package com.j1j2.common.base

import eu.davidea.flexibleadapter.FlexibleAdapter.HandlerCallback
import eu.davidea.flexibleadapter.FlexibleAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import android.os.Looper



/**
 * Created by zxh19 on 2017/7/16.
 */
class BaseAdapter(items: List<AbstractFlexibleItem<*>>, listeners: Any) : FlexibleAdapter<AbstractFlexibleItem<*>>(items, listeners, true) {



    companion object {

        private val TAG = BaseAdapter::class.java.simpleName
    }

}