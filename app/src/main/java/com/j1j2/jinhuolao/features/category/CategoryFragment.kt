package com.j1j2.jinhuolao.features.category

import com.j1j2.common.base.BaseMviFragment
import javax.inject.Inject


/**
 * Created by albertz on 17-7-13.
 */
class CategoryFragment : BaseMviFragment<CategoryUI, CategoryView, CategoryPresenter>(),CategoryView {


    @Inject lateinit var categoryPresenter: CategoryPresenter

    override fun createUI(): CategoryUI = CategoryUI()

    override fun createPresenter(): CategoryPresenter = categoryPresenter
}