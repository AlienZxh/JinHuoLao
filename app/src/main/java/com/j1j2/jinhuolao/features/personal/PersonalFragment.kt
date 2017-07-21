package com.j1j2.jinhuolao.features.personal

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuInflater
import com.j1j2.common.base.BaseAdapter
import com.j1j2.common.base.BaseMviFragment
import com.j1j2.jinhuolao.R
import com.j1j2.jinhuolao.items.PersonalHeadItem
import com.j1j2.jinhuolao.items.SettingItem
import com.j1j2.jinhuolao.items.SettingOffsetItem
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import javax.inject.Inject


/**
 * Created by albertz on 17-7-13.
 */
class PersonalFragment : BaseMviFragment<PersonalUI, PersonalView, PersonalPresenter>(), PersonalView {

    @Inject lateinit var personalPresenter: PersonalPresenter
    lateinit var baseAdapter: BaseAdapter

    override fun createUI(): PersonalUI {
        val head0 = SettingOffsetItem(0)
        val head1 = SettingOffsetItem(1)
        val head2 = SettingOffsetItem(2)
        val list = arrayListOf<AbstractFlexibleItem<out RecyclerView.ViewHolder>>()
        list.add(head0)
        list.add(SettingItem("个人资料", IconicsDrawable(context)
                .icon(CommunityMaterial.Icon.cmd_account_box)
                .color(ContextCompat.getColor(context, R.color.color_text_666))
                .sizeDp(24), head1))
        list.add(head1)
        list.add(SettingItem("我的订单", IconicsDrawable(context)
                .icon(CommunityMaterial.Icon.cmd_clipboard_text)
                .color(ContextCompat.getColor(context, R.color.color_text_666))
                .sizeDp(24), head1))

        list.add(SettingItem("我的消息", IconicsDrawable(context)
                .icon(CommunityMaterial.Icon.cmd_message_bulleted)
                .color(ContextCompat.getColor(context, R.color.color_text_666))
                .sizeDp(24), head1))
        list.add(SettingItem("我的收藏", IconicsDrawable(context)
                .icon(CommunityMaterial.Icon.cmd_heart_box)
                .color(ContextCompat.getColor(context, R.color.color_text_666))
                .sizeDp(24), head1))
        list.add(head2)
        list.add(SettingItem("我的设置", IconicsDrawable(context)
                .icon(CommunityMaterial.Icon.cmd_settings_box)
                .color(ContextCompat.getColor(context, R.color.color_text_666))
                .sizeDp(24), head2))
        baseAdapter = BaseAdapter(list, this)
        return PersonalUI(baseAdapter)
    }

    override fun createPresenter(): PersonalPresenter = personalPresenter

    override fun initView(ui: PersonalUI) {
        super.initView(ui)
        setHasOptionsMenu(true)


    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu?.clear()
        inflater?.inflate(R.menu.personal_toolbar, menu)
        menu?.findItem(R.id.setting)?.setIcon(IconicsDrawable(context).icon(CommunityMaterial.Icon.cmd_settings).color(Color.WHITE).sizeDp(24))
    }
}