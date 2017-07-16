package com.j1j2.jinhuolao.items

import android.animation.Animator
import android.view.View
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import eu.davidea.flexibleadapter.helpers.AnimatorHelper
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import com.j1j2.jinhuolao.R
import eu.davidea.flexibleadapter.items.ISectionable


/**
 * Created by zxh19 on 2017/7/16.
 */
class ShopcartItem(var id: Int) : AbstractFlexibleItem<ShopcartItem.ShopcartViewHolder>(), IFlexible<ShopcartItem.ShopcartViewHolder> {
    init {
        mSelectable = true
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ShopcartItem
        return id == that.id
    }

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?): ShopcartViewHolder = ShopcartViewHolder(view!!, adapter!!)

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: ShopcartViewHolder?, position: Int, payloads: MutableList<Any?>?) {


    }

    override fun getLayoutRes(): Int = R.layout.item_shopcart

    class ShopcartViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {

        init {

        }



        override fun scrollAnimators(animators: MutableList<Animator>, position: Int, isForward: Boolean) {
            if (isForward)
                AnimatorHelper.slideInFromBottomAnimator(animators, itemView, mAdapter.getRecyclerView());
            else
                AnimatorHelper.slideInFromTopAnimator(animators, itemView, mAdapter.getRecyclerView());
        }
    }
}
