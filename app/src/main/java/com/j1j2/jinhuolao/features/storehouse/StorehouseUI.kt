package com.j1j2.jinhuolao.features.storehouse

import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.j1j2.common.base.BaseAdapter
import com.j1j2.jinhuolao.R
import eu.davidea.flexibleadapter.common.SmoothScrollGridLayoutManager
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView


/**
 * Created by albertz on 17-7-13.
 */
class StorehouseUI(val baseAdapter: BaseAdapter) : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>): View {
        return with(ui) {
            recyclerView {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.colorLayoutBackgroundLight
                val gridLayoutManager = SmoothScrollGridLayoutManager(ctx, 4)
                gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return baseAdapter.getItem(position)?.getSpanSize(4, position) ?: 1
                    }
                }
                layoutManager = gridLayoutManager
                itemAnimator = DefaultItemAnimator()

                adapter = baseAdapter

            }
        }
    }
}