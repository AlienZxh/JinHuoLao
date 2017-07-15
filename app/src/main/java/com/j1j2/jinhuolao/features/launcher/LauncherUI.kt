package com.j1j2.jinhuolao.features.launcher

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.FrameLayout
import com.j1j2.jinhuolao.R
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by albertz on 17-7-7.
 */
class LauncherUI : AnkoComponent<AppCompatActivity> {
    lateinit var layout: FrameLayout

    override fun createView(ui: AnkoContext<AppCompatActivity>): View {
        layout = with(ui) {
            frameLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.colorPrimary


            }
        }
        return layout;
    }

}