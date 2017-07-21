package com.j1j2.jinhuolao.items

import android.view.View
import android.widget.TextView
import com.j1j2.jinhuolao.R
import com.mikepenz.iconics.view.IconicsImageView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import org.jetbrains.anko.find

/**
 * Created by albertz on 17-7-21.
 */
class SettingOffsetItem constructor(val id: Int) : AbstractHeaderItem<SettingOffsetItem.SettingOffsetViewHolder>() {


    override fun bindViewHolder(p0: FlexibleAdapter<out IFlexible<*>>?, p1: SettingOffsetViewHolder?, p2: Int, p3: MutableList<Any?>?) {

    }

    override fun createViewHolder(p0: View, p1: FlexibleAdapter<out IFlexible<*>>): SettingOffsetViewHolder = SettingOffsetViewHolder(p0, p1)

    override fun getLayoutRes(): Int = R.layout.item_setting_offset

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ShopcartItem
        return id == that.id
    }


    class SettingOffsetViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {
    }
}