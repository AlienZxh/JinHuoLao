package com.j1j2.jinhuolao.items

import android.animation.Animator
import android.graphics.Color
import android.view.View
import com.j1j2.jinhuolao.R
import com.j1j2.jinhuolao.features.storehouse.StorehouseBannerAdapter
import com.tmall.ultraviewpager.UltraViewPager
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.helpers.AnimatorHelper
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import org.jetbrains.anko.find
import android.util.TypedValue
import android.view.Gravity
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ToastUtils.setGravity





/**
 * Created by albertz on 17-7-21.
 */
class StorehouseBannerItem : AbstractHeaderItem<StorehouseBannerItem.StorehouseBannerViewHolder>() {

    override fun createViewHolder(p0: View?, p1: FlexibleAdapter<out IFlexible<*>>?): StorehouseBannerViewHolder =StorehouseBannerViewHolder(p0,p1)

    override fun bindViewHolder(p0: FlexibleAdapter<out IFlexible<*>>?, holder: StorehouseBannerViewHolder?, p2: Int, p3: MutableList<Any?>?) {
        holder!!.viewpager.adapter = StorehouseBannerAdapter(true)
        holder.viewpager.initIndicator()
        holder.viewpager.getIndicator()
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE)
                .setRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5f, holder.itemView.context.getResources().getDisplayMetrics()).toInt())
                .setMargin(0,0,0,ConvertUtils.dp2px(8f))
        holder.viewpager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM)
        holder.viewpager.getIndicator().build()
        holder.viewpager.setMultiScreen(1.0f);
        holder.viewpager.setItemRatio(2.5)
        holder.viewpager.setAutoMeasureHeight(true);

        holder.viewpager.setInfiniteLoop(true);
        holder.viewpager.setAutoScroll(2000);
    }

    override fun unbindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: StorehouseBannerViewHolder?, position: Int) {
        super.unbindViewHolder(adapter, holder, position)
        holder!!.viewpager.disableAutoScroll()
    }

    override fun getLayoutRes(): Int = R.layout.item_storehouse_banner

    override fun equals(other: Any?): Boolean {
        return true
    }
    class StorehouseBannerViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?) : FlexibleViewHolder(view, adapter) {
        val viewpager: UltraViewPager


        init {
            viewpager = itemView.find<UltraViewPager>(R.id.ultra_viewpager)
        }
//        override fun scrollAnimators(animators: MutableList<Animator>, position: Int, isForward: Boolean) {
//            AnimatorHelper.flipAnimator(animators, itemView)
//            AnimatorHelper.setDuration(animators, 500L)
//        }
    }
}