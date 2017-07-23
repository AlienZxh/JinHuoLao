package com.j1j2.jinhuolao.items

import android.animation.Animator
import android.view.View
import com.j1j2.jinhuolao.R
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.helpers.AnimatorHelper
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder

/**
 * Created by zxh19 on 2017/7/23.
 */
class StorehouseHeadItem(val id:Int) : AbstractHeaderItem<StorehouseHeadItem.StorehouseHeadViewHolder>(){


    override fun getSpanSize(spanCount: Int, position: Int): Int {
        return spanCount
    }

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?): StorehouseHeadItem.StorehouseHeadViewHolder = StorehouseHeadItem.StorehouseHeadViewHolder(view, adapter)

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>, holder: StorehouseHeadItem.StorehouseHeadViewHolder, position: Int, payloads: MutableList<Any?>) {

    }

    override fun getLayoutRes(): Int = R.layout.item_storehouse_head

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as StorehouseHeadItem
        return id == that.id
    }

    class StorehouseHeadViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?) : FlexibleViewHolder(view, adapter) {


        override fun scrollAnimators(animators: MutableList<Animator>, position: Int, isForward: Boolean) {
            AnimatorHelper.flipAnimator(animators, itemView)
            AnimatorHelper.setDuration(animators, 500L)
        }
    }
}