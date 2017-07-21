package com.j1j2.jinhuolao.items

import android.view.View
import android.widget.TextView
import com.j1j2.jinhuolao.R
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.view.IconicsImageView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.flexibleadapter.items.ISectionable
import eu.davidea.viewholders.FlexibleViewHolder
import org.jetbrains.anko.find

/**
 * Created by albertz on 17-7-20.
 */
class SettingItem(val text: String, val icon: IconicsDrawable, var head: SettingOffsetItem) : AbstractFlexibleItem<SettingItem.SettingViewHolder>(), ISectionable<SettingItem.SettingViewHolder, SettingOffsetItem> {


    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?): SettingViewHolder = SettingViewHolder(view!!, adapter!!)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SettingItem
        return text == that.text
    }

    override fun setHeader(p0: SettingOffsetItem) {
        head = p0
    }

    override fun getHeader(): SettingOffsetItem {
        return head
    }

    override fun bindViewHolder(p0: FlexibleAdapter<out IFlexible<*>>?, holder: SettingViewHolder?, p2: Int, p3: MutableList<Any?>?) {
        holder!!.icon.setIcon(icon)
        holder.text.setText(text)
    }

    override fun getLayoutRes(): Int = R.layout.item_setting

    override fun hashCode(): Int {
        return text.hashCode()
    }

    class SettingViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {

        val icon: IconicsImageView
        val text: TextView


        init {
            icon = itemView.find<IconicsImageView>(R.id.icon)
            text = itemView.find<TextView>(R.id.text)
        }


    }
}