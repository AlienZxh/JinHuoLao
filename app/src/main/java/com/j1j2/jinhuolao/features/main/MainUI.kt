package com.j1j2.jinhuolao.features.main

import android.graphics.Color
import android.os.Build
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.View
import com.j1j2.common.widgets.attrAsDimen
import com.j1j2.jinhuolao.R
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.design.bottomNavigationView
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.support.v4.viewPager

/**
 * Created by albertz on 17-7-13.
 */
class MainUI : AnkoComponent<AppCompatActivity> {

    lateinit var layout: CoordinatorLayout
    lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<AppCompatActivity>): View {
        layout = with(ui) {
            coordinatorLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.colorLayoutBackgroundLight

                themedAppBarLayout(theme = R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {

                    toolbar = themedToolbar(theme = R.style.AppTheme_AppBar_Light) {
                        popupTheme = R.style.AppTheme_Overlay_Light
                        id = R.id.toolbar
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) elevation = 4f

                    }.lparams(width = matchParent, height = ctx.attrAsDimen(R.attr.actionBarSize))

                }.lparams(width = matchParent, height = wrapContent)

                viewPager { }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = ctx.attrAsDimen(R.attr.actionBarSize)
                    bottomMargin = dip(56)
                }

                bottomNavigationView {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) elevation = 4f

                    inflateMenu(R.menu.main_bottom_navigation)
                    menu.findItem(R.id.storehouse).setIcon(IconicsDrawable(ctx).icon(CommunityMaterial.Icon.cmd_store).color(Color.GRAY).sizeDp(24))
                    menu.findItem(R.id.category).setIcon(IconicsDrawable(ctx).icon(CommunityMaterial.Icon.cmd_format_list_bulleted_type).color(Color.GRAY).sizeDp(24))
                    menu.findItem(R.id.mine).setIcon(IconicsDrawable(ctx).icon(CommunityMaterial.Icon.cmd_account).color(Color.GRAY).sizeDp(24))

                }.lparams(width = matchParent, height = dip(56)) {
                    gravity = Gravity.BOTTOM or Gravity.END
                }
            }
        }


        return layout;
    }
}