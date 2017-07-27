package com.j1j2.jinhuolao.items

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.blankj.utilcode.util.SizeUtils
import com.j1j2.jinhuolao.R
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.flexibleadapter.utils.DrawableUtils
import eu.davidea.flexibleadapter.utils.FlexibleUtils
import eu.davidea.viewholders.FlexibleViewHolder
import org.jetbrains.anko.find

/**
 * Created by zxh19 on 2017/7/23.
 */
class CategorySecondItem : AbstractFlexibleItem<CategorySecondItem.CategorySecondViewHolder>() {


    override fun createViewHolder(view: View, adapter: FlexibleAdapter<out IFlexible<*>>): CategorySecondViewHolder = CategorySecondViewHolder(view, adapter)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return false
    }

    override fun getLayoutRes(): Int = R.layout.item_category_second

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: CategorySecondViewHolder?, position: Int, payloads: MutableList<Any?>?) {

        val context = holder?.itemView?.context
        val drawable = DrawableUtils.getSelectableBackgroundCompat(
                Color.TRANSPARENT, Color.WHITE, // Same color of divider
                DrawableUtils.getColorControlHighlight(context))
        DrawableUtils.setBackgroundCompat(holder?.itemView, drawable)
    }

    class CategorySecondViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {
        var text: TextView


        init {
            text = itemView.find<TextView>(R.id.text)

        }

        override fun toggleActivation() {
            super.toggleActivation()
            val selected = mAdapter.isSelected(adapterPosition)
            if (selected) {
                FlexibleUtils.highlightText(
                        text, text.text.toString(), text.text.toString())

            } else {
                text.setText("分类")

            }
        }

        override fun getActivationElevation(): Float {
            return SizeUtils.dp2px(4f).toFloat()
        }
    }
}