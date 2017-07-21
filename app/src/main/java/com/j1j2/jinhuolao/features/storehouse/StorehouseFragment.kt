package com.j1j2.jinhuolao.features.storehouse

import android.support.v4.content.ContextCompat
import com.j1j2.common.base.BaseAdapter
import com.j1j2.common.base.BaseMviFragment
import com.j1j2.jinhuolao.R
import com.j1j2.jinhuolao.features.personal.PersonalUI
import com.j1j2.jinhuolao.items.SettingItem
import com.j1j2.jinhuolao.items.StorehouseBannerItem
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable
import javax.inject.Inject


/**
 * Created by albertz on 17-7-13.
 */
class StorehouseFragment : BaseMviFragment<StorehouseUI, StorehouseView, StorehousePresenter>(), StorehouseView {

    @Inject lateinit var storehousePresenter: StorehousePresenter
    lateinit var baseAdapter: BaseAdapter

    override fun createUI(): StorehouseUI {

        baseAdapter = BaseAdapter(arrayListOf(), this)
        return StorehouseUI(baseAdapter)
    }

    override fun createPresenter(): StorehousePresenter = storehousePresenter
    
    override fun initView(ui: StorehouseUI) {
        super.initView(ui)
        baseAdapter.addScrollableHeader(StorehouseBannerItem())
    }

}