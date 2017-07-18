package com.j1j2.jinhuolao.features.main

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.j1j2.jinhuolao.features.launcher.LauncherView
import com.j1j2.jinhuolao.features.launcher.LauncherViewState
import javax.inject.Inject

/**
 * Created by albertz on 17-7-14.
 */
class MainPresenter @Inject constructor() : MviBasePresenter<MainView, MainViewState>(){

    override fun bindIntents() {

    }
}