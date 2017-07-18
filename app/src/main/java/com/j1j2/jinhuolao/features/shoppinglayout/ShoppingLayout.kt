package com.j1j2.jinhuolao.features.shoppinglayout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.hannesdorfmann.mosby3.mvi.layout.MviFrameLayout
import com.j1j2.common.R

/**
 * Created by albertz on 17-7-17.
 */
class ShoppingLayout : MviFrameLayout<ShoppingView, ShoppingPresenter> {

    constructor(context: Context?) : super(context) {
        init(context!!)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context!!)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context!!)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context!!)
    }

    private fun init(context: Context) {
//        val layoutInflater = LayoutInflater.from(context);
//        val view = layoutInflater.inflate(R.layout.view_shoppinglayout, null, false)
//
//        if (view.getParent() == null) {
//            this.addView(view)
//        }

    }


    override fun createPresenter(): ShoppingPresenter = ShoppingPresenter()

}