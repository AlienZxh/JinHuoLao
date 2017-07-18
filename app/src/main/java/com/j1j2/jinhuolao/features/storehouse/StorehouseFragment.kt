package com.j1j2.jinhuolao.features.storehouse

import com.j1j2.common.base.BaseMviFragment
import javax.inject.Inject


/**
 * Created by albertz on 17-7-13.
 */
class StorehouseFragment : BaseMviFragment<StorehouseUI, StorehouseView, StorehousePresenter>(), StorehouseView {

    @Inject lateinit var storehousePresenter: StorehousePresenter

    override fun createPresenter(): StorehousePresenter = storehousePresenter

    override fun createUI(): StorehouseUI = StorehouseUI()
}