package com.j1j2.jinhuolao.features.products

import android.graphics.Color
import android.os.Build
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.View
import com.j1j2.common.widgets.BaseStatefulLayout
import com.j1j2.common.widgets.attrAsDimen
import com.j1j2.common.widgets.baseStatefulLayout
import com.j1j2.jinhuolao.R
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.design.bottomNavigationView
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.viewPager

/**
 * Created by albertz on 17-7-13.
 */
class ProductsUI : AnkoComponent<AppCompatActivity> {
    lateinit var baseStatefulLayout: BaseStatefulLayout
    override fun createView(ui: AnkoContext<AppCompatActivity>): View {
        return with(ui) {

            coordinatorLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.colorLayoutBackgroundLight

                themedAppBarLayout(theme = R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {

                    themedToolbar(theme = R.style.AppTheme_AppBar_Light) {
                        popupTheme = R.style.AppTheme_Overlay_Light
                        minimumHeight = ctx.attrAsDimen(R.attr.actionBarSize)
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) elevation = dip(8).toFloat()

                        owner.setSupportActionBar(this)
                    }.lparams(width = matchParent, height = ctx.attrAsDimen(R.attr.actionBarSize)) {
                        scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                    }

                }.lparams(width = matchParent, height = wrapContent)

                baseStatefulLayout = baseStatefulLayout {

                }.lparams(width = matchParent, height = matchParent) {
                    topMargin = ctx.attrAsDimen(R.attr.actionBarSize)
                }


            }
        }
    }
}