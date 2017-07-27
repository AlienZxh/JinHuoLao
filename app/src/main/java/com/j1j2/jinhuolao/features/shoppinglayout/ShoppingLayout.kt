package com.j1j2.jinhuolao.features.shoppinglayout

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.hannesdorfmann.mosby3.mvi.layout.MviFrameLayout
import com.j1j2.jinhuolao.R
import org.jetbrains.anko.find
import android.support.v4.view.ViewCompat.setTranslationY
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.opengl.ETC1.getHeight
import eu.davidea.flexibleadapter.helpers.AnimatorHelper.setDuration
import android.animation.ObjectAnimator






/**
 * Created by albertz on 17-7-17.
 */
class ShoppingLayout : MviFrameLayout<ShoppingView, ShoppingPresenter> {

    lateinit var subBtn: AppCompatButton
    lateinit var plusBtn: AppCompatButton
    lateinit var quantityEdit: AppCompatEditText

    var quantity = 0

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
        val layoutInflater = LayoutInflater.from(context);
        val view = layoutInflater.inflate(R.layout.view_shoppinglayout, this, false)

        if (view.getParent() == null) {
            this.addView(view)
        }

        subBtn = view.find<AppCompatButton>(R.id.sub_btn)
        plusBtn = view.find<AppCompatButton>(R.id.plus_btn)
        quantityEdit = view.find<AppCompatEditText>(R.id.quantity_edit)

        if (quantity == 0) {
            subBtn.visibility = View.GONE
            quantityEdit.visibility = View.GONE
            plusBtn.setText("点击购买")
        }else{
            quantityEdit.setText(quantity.toString())
        }

    }


    override fun createPresenter(): ShoppingPresenter = ShoppingPresenter()

}