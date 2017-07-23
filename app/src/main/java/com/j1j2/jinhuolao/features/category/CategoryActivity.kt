package com.j1j2.jinhuolao.features.category

import android.support.v7.widget.RecyclerView
import com.j1j2.common.base.BaseAdapter
import com.j1j2.common.base.BaseMviActivity
import com.j1j2.jinhuolao.items.CategorySecondItem
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.SelectableAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import javax.inject.Inject


/**
 * Created by albertz on 17-7-13.
 */
class CategoryActivity : BaseMviActivity<CategoryUI, CategoryView, CategoryPresenter>(), CategoryView, FlexibleAdapter.OnItemClickListener {


    @Inject lateinit var categoryPresenter: CategoryPresenter
    lateinit var categorySecondAdapter: BaseAdapter

    override fun createUI(): CategoryUI {
        val list = arrayListOf<AbstractFlexibleItem<out RecyclerView.ViewHolder>>()

        list.add(CategorySecondItem())
        list.add(CategorySecondItem())
        list.add(CategorySecondItem())
        list.add(CategorySecondItem())
        list.add(CategorySecondItem())
        list.add(CategorySecondItem())
        list.add(CategorySecondItem())
        list.add(CategorySecondItem())
        categorySecondAdapter = BaseAdapter(list, this)
        return CategoryUI(categorySecondAdapter)
    }

    override fun createPresenter(): CategoryPresenter = categoryPresenter

    override fun initView(ui: CategoryUI) {
        super.initView(ui)

        categorySecondAdapter.setMode(SelectableAdapter.Mode.SINGLE)
    }

    override fun onItemClick(position: Int): Boolean {
        categorySecondAdapter.toggleSelection(position);
        return true
    }
}