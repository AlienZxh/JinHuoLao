package com.j1j2.common.views

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import com.j1j2.common.R
import org.jetbrains.anko.*

/**
 * Created by albertz on 17-7-17.
 */
class StateEmptyViewUI : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>): View {
        return with(ui) {
            verticalLayout {
                lparams(width = matchParent, height = matchParent) {
                    gravity = Gravity.CENTER
                }
                textView(ctx.getText(R.string.empty_icon)) {
                    textSize = dimen(R.dimen.material_typography_title).toFloat()
                    textColor = ContextCompat.getColor(ctx, R.color.color_text_666)

                }.lparams(width = wrapContent, height = wrapContent)
                textView("暂无内容") {
                    textSize = dimen(R.dimen.material_typography_body1).toFloat()
                    textColor = ContextCompat.getColor(ctx, R.color.color_text_666)

                }.lparams(width = wrapContent, height = wrapContent) {
                    topMargin = dip(16)
                }
            }
        }
    }
}