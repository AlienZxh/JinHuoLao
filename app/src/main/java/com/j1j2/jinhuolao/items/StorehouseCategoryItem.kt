package com.j1j2.jinhuolao.items

import android.view.View
import android.widget.TextView
import com.j1j2.jinhuolao.R
import com.mikepenz.iconics.view.IconicsImageView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.flexibleadapter.items.ISectionable
import eu.davidea.viewholders.FlexibleViewHolder
import org.jetbrains.anko.find

/**
 * Created by zxh19 on 2017/7/23.
 */
class StorehouseCategoryItem(var head: StorehouseHeadItem) : AbstractFlexibleItem<StorehouseCategoryItem.StorehouseCategoryViewHolder>(), ISectionable<StorehouseCategoryItem.StorehouseCategoryViewHolder, StorehouseHeadItem> {

    override fun getSpanSize(spanCount: Int, position: Int): Int {
        return spanCount / 4
    }

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: StorehouseCategoryViewHolder?, position: Int, payloads: MutableList<Any?>?) {
    }

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<out IFlexible<*>>): StorehouseCategoryViewHolder = StorehouseCategoryViewHolder(view, adapter)

    override fun getLayoutRes(): Int = R.layout.item_storehouse_category

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return false
    }

    override fun getHeader(): StorehouseHeadItem {
        return head
    }

    override fun setHeader(header: StorehouseHeadItem) {
        head = header
    }

    class StorehouseCategoryViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {

    }
}