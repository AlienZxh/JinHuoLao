package com.j1j2.jinhuolao.features.personal

import com.j1j2.common.base.BaseMviFragment
import javax.inject.Inject


/**
 * Created by albertz on 17-7-13.
 */
class PersonalFragment : BaseMviFragment<PersonalUI,PersonalView,PersonalPresenter>(),PersonalView{

   @Inject lateinit var personalPresenter:PersonalPresenter

    override fun createUI(): PersonalUI = PersonalUI()

    override fun createPresenter(): PersonalPresenter =personalPresenter
}