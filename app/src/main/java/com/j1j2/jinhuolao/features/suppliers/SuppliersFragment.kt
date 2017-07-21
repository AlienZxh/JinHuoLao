package com.j1j2.jinhuolao.features.suppliers

import com.j1j2.common.base.BaseMviFragment
import javax.inject.Inject


/**
 * Created by albertz on 17-7-13.
 */
class SuppliersFragment : BaseMviFragment<SuppliersUI, SuppliersView, SuppliersPresenter>(),SuppliersView {


    @Inject lateinit var SuppliersPresenter: SuppliersPresenter

    override fun createUI(): SuppliersUI = SuppliersUI()

    override fun createPresenter(): SuppliersPresenter = SuppliersPresenter
}