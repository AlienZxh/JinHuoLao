package com.j1j2.jinhuolao.features.personal

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import javax.inject.Inject

/**
 * Created by albertz on 17-7-14.
 */
class PersonalPresenter @Inject constructor() :MviBasePresenter<PersonalView, PersonalViewState>(){

    override fun bindIntents() {
    }
}