package com.j1j2.jinhuolao.items

import android.animation.Animator
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.view.View
import android.widget.TextView
import com.blankj.utilcode.util.SizeUtils
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import eu.davidea.flexibleadapter.helpers.AnimatorHelper
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import com.j1j2.jinhuolao.R
import eu.davidea.flexibleadapter.items.ISectionable
import eu.davidea.flexibleadapter.utils.DrawableUtils
import eu.davidea.flexibleadapter.utils.FlexibleUtils
import org.jetbrains.anko.find


/**
 * Created by zxh19 on 2017/7/16.
 */
class ShopcartItem(var id: Int) : AbstractFlexibleItem<ShopcartItem.ShopcartViewHolder>(), IFlexible<ShopcartItem.ShopcartViewHolder>, Parcelable {
    init {
        mSelectable = true
    }


    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ShopcartItem
        return id == that.id
    }

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?): ShopcartViewHolder = ShopcartViewHolder(view!!, adapter!!)

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: ShopcartViewHolder?, position: Int, payloads: MutableList<Any?>?) {
        val context = holder?.itemView?.context
        val drawable = DrawableUtils.getSelectableBackgroundCompat(
                Color.WHITE, Color.parseColor("#dddddd"), // Same color of divider
                DrawableUtils.getColorControlHighlight(context))
        DrawableUtils.setBackgroundCompat(holder?.itemView, drawable)
    }

    override fun getLayoutRes(): Int = R.layout.item_shopcart

    override fun hashCode(): Int = id


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShopcartItem> {
        override fun createFromParcel(parcel: Parcel): ShopcartItem {
            return ShopcartItem(parcel)
        }

        override fun newArray(size: Int): Array<ShopcartItem?> {
            return arrayOfNulls(size)
        }
    }


    class ShopcartViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {

        var productName: TextView
        var productInfo1: TextView
        var productInfo2: TextView

        init {
            productName = itemView.find<TextView>(R.id.product_name)
            productInfo1 = itemView.find<TextView>(R.id.product_info1)
            productInfo2 = itemView.find<TextView>(R.id.product_info2)
        }

        override fun toggleActivation() {
            super.toggleActivation()
            val selected = mAdapter.isSelected(adapterPosition)
            if (selected) {
                FlexibleUtils.highlightText(
                        productName, productName.text.toString(), productName.text.toString())
                FlexibleUtils.highlightText(
                        productInfo1, productInfo1.text.toString(), productInfo1.text.toString())
                FlexibleUtils.highlightText(
                        productInfo2, productInfo2.text.toString(), productInfo2.text.toString())
            } else {
                productName.setText("商品名称很长长长长长长长长长长长长长长长长长")
                productInfo1.setText("商品信息")
                productInfo2.setText("商品信息")
            }
        }

        override fun getActivationElevation(): Float {
            return SizeUtils.dp2px(4f).toFloat()
        }

        override fun scrollAnimators(animators: MutableList<Animator>, position: Int, isForward: Boolean) {
            if (isForward)
                AnimatorHelper.slideInFromBottomAnimator(animators, itemView, mAdapter.getRecyclerView());
            else
                AnimatorHelper.slideInFromTopAnimator(animators, itemView, mAdapter.getRecyclerView());
        }
    }
}
