package com.j1j2.jinhuolao.features.category

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.hannesdorfmann.mosby3.mvi.MviPresenter
import javax.inject.Inject

/**
 * Created by albertz on 17-7-14.
 */
class CategoryPresenter @Inject constructor() : MviBasePresenter<CategoryView, CategoryViewState>() {

    override fun bindIntents() {
    }
}