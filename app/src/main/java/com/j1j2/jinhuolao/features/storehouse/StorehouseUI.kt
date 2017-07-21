package com.j1j2.jinhuolao.features.storehouse

import android.graphics.Color
import android.os.Build
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.View
import com.j1j2.common.base.BaseAdapter
import com.j1j2.common.widgets.attrAsDimen
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
class StorehouseUI(val baseAdapter: BaseAdapter) : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>): View {
        return with(ui) {
            recyclerView {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.colorLayoutBackgroundLight

                layoutManager = SmoothScrollLinearLayoutManager(ctx)
                itemAnimator = DefaultItemAnimator()

                adapter = baseAdapter

            }
        }
    }
}