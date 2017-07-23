package com.j1j2.jinhuolao.items

import android.view.View
import com.j1j2.jinhuolao.R
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.flexibleadapter.items.ISectionable
import eu.davidea.viewholders.FlexibleViewHolder

/**
 * Created by zxh19 on 2017/7/23.
 */
class StorehouseSaleItem(var head: StorehouseHeadItem) : AbstractFlexibleItem<StorehouseSaleItem.StorehouseSaleViewHolder>(), ISectionable<StorehouseSaleItem.StorehouseSaleViewHolder, StorehouseHeadItem> {

    override fun getSpanSize(spanCount: Int, position: Int): Int {
        return spanCount
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return false
    }

    override fun getLayoutRes(): Int = R.layout.item_storehouse_sale

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<out IFlexible<*>>): StorehouseSaleViewHolder =StorehouseSaleViewHolder(view ,adapter)

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: StorehouseSaleViewHolder?, position: Int, payloads: MutableList<Any?>?) {
    }

    override fun getHeader(): StorehouseHeadItem {
        return  head
    }

    override fun setHeader(header: StorehouseHeadItem) {
        head = header
    }

    class StorehouseSaleViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {

    }
}