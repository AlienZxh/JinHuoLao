package com.j1j2.jinhuolao.features.storehouse

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import javax.inject.Inject

/**
 * Created by albertz on 17-7-14.
 */
class StorehousePresenter @Inject constructor() :MviBasePresenter<StorehouseView,StorehouseViewState>(){
    override fun bindIntents() {
    }
}