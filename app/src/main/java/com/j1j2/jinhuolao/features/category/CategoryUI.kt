package com.j1j2.jinhuolao.features.category

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.j1j2.common.base.BaseAdapter
import com.j1j2.common.widgets.attrAsDimen
import com.j1j2.jinhuolao.R
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by albertz on 17-7-13.
 */
class CategoryUI(val categorySecondAdapter: BaseAdapter) : AnkoComponent<AppCompatActivity> {

    override fun createView(ui: AnkoContext<AppCompatActivity>): View {
        return with(ui) {
            frameLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.colorLayoutBackgroundLight

                themedAppBarLayout(theme = R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {

                    themedToolbar(theme = R.style.AppTheme_AppBar_Light) {
                        popupTheme = R.style.AppTheme_Overlay_Light
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) elevation = dip(8).toFloat()

                        owner.setSupportActionBar(this@themedToolbar)
                    }.lparams(width = matchParent, height = ctx.attrAsDimen(R.attr.actionBarSize))

                }.lparams(width = matchParent, height = wrapContent)

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL

                    recyclerView {
                        layoutManager = SmoothScrollLinearLayoutManager(ctx)

                        adapter = categorySecondAdapter;
                    }.lparams(width = dip(0), height = matchParent, weight = 1f)
                    recyclerView {
                        backgroundResource = R.color.material_blue_500
                    }.lparams(width = dip(0), height = matchParent, weight = 2.5f)

                }.lparams(width = matchParent, height = matchParent) {
                    topMargin = ctx.attrAsDimen(R.attr.actionBarSize)
                }

            }
        }
    }
}