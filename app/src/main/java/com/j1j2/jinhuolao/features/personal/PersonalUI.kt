package com.j1j2.jinhuolao.features.personal

import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.view.View
import com.j1j2.common.base.BaseAdapter
import com.j1j2.jinhuolao.R
import com.j1j2.jinhuolao.items.PersonalHeadItem
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by albertz on 17-7-13.
 */
class PersonalUI(val baseAdapter: BaseAdapter) : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>): View {
        return with(ui) {
            recyclerView {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.colorLayoutBackgroundLight

                layoutManager = SmoothScrollLinearLayoutManager(ctx)
                itemAnimator = DefaultItemAnimator()
                addItemDecoration(FlexibleItemDecoration(ctx)
                        .withDefaultDivider()
                        .withDrawOver(true))
                baseAdapter.addScrollableHeader(PersonalHeadItem())
                baseAdapter.setUnlinkAllItemsOnRemoveHeaders(true)
                        .setStickyHeaders(false)
                adapter = baseAdapter

            }
        }
    }
}