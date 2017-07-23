package com.j1j2.jinhuolao.features.storehouse

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.j1j2.common.base.BaseAdapter
import com.j1j2.common.base.BaseMviFragment
import com.j1j2.jinhuolao.R
import com.j1j2.jinhuolao.features.personal.PersonalUI
import com.j1j2.jinhuolao.items.*
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import javax.inject.Inject


/**
 * Created by albertz on 17-7-13.
 */
class StorehouseFragment : BaseMviFragment<StorehouseUI, StorehouseView, StorehousePresenter>(), StorehouseView {

    @Inject lateinit var storehousePresenter: StorehousePresenter
    lateinit var baseAdapter: BaseAdapter

    override fun createUI(): StorehouseUI {
        val head0 = StorehouseHeadItem(0)
        val head1 = StorehouseHeadItem(1)

        val list = arrayListOf<AbstractFlexibleItem<out RecyclerView.ViewHolder>>()
        list.add(StorehouseBannerItem())
        list.add(head0)
        list.add(StorehouseCategoryItem( head0))
        list.add(StorehouseCategoryItem( head0))
        list.add(StorehouseCategoryItem( head0))
        list.add(StorehouseCategoryItem( head0))
        list.add(StorehouseCategoryItem( head0))
        list.add(StorehouseCategoryItem( head0))
        list.add(StorehouseCategoryItem( head0))
        list.add(StorehouseCategoryItem( head0))
        list.add(head1)
        list.add(StorehouseSaleItem( head1))
        list.add(StorehouseSaleItem( head1))
        list.add(StorehouseSaleItem( head1))
        list.add(StorehouseSaleItem( head1))
        list.add(StorehouseSaleItem( head1))
        list.add(StorehouseSaleItem( head1))

        baseAdapter = BaseAdapter(list, this)
        return StorehouseUI(baseAdapter)
    }

    override fun createPresenter(): StorehousePresenter = storehousePresenter
    


}