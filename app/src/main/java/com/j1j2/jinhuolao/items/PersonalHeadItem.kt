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
 * Created by albertz on 17-7-20.
 */
class PersonalHeadItem : AbstractHeaderItem<PersonalHeadItem.PesonalHeadViewHolder>() {
    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?): PesonalHeadViewHolder  = PesonalHeadViewHolder(view,adapter)

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: PesonalHeadViewHolder?, position: Int, payloads: MutableList<Any?>?) {

    }

    override fun getLayoutRes(): Int = R.layout.item_personalhead

    override fun equals(other: Any?): Boolean {

        return true
    }



    class PesonalHeadViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?) : FlexibleViewHolder(view, adapter) {


        override fun scrollAnimators(animators: MutableList<Animator>, position: Int, isForward: Boolean) {
            AnimatorHelper.flipAnimator(animators, itemView)
            AnimatorHelper.setDuration(animators, 500L)
        }
    }
}