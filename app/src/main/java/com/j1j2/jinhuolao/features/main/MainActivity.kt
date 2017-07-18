package com.j1j2.jinhuolao.features.main

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import com.j1j2.common.base.BaseMviActivity
import com.j1j2.jinhuolao.R
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable
import javax.inject.Inject

/**
 * Created by albertz on 17-7-13.
 */
class MainActivity : BaseMviActivity<MainUI, MainView, MainPresenter>(), MainView {

    @Inject lateinit var mainPresenter: MainPresenter
    var prevMenuItem: MenuItem? = null

    override fun initView(ui: MainUI) {
        super.initView(ui)
        ui.bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.storehouse -> {
                        ui.viewPager.currentItem = 0
                        return true
                    }
                    R.id.category -> {
                        ui.viewPager.currentItem = 1
                        return true
                    }
                    R.id.personal -> {
                        ui.viewPager.currentItem = 2
                        return true
                    }
                }
                return false
            }
        })

        ui.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {

                if (prevMenuItem != null) {
                    prevMenuItem!!.setChecked(false);
                } else {
                    ui.bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                prevMenuItem = ui.bottomNavigationView.getMenu().getItem(position);
                prevMenuItem?.setChecked(true);

            }
        })
    }

    override fun createUI(): MainUI = MainUI(MainAdapter(supportFragmentManager))

    override fun createPresenter(): MainPresenter = mainPresenter

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_toolbar, menu)
        menu.findItem(R.id.qrscan).setIcon(IconicsDrawable(this).icon(CommunityMaterial.Icon.cmd_qrcode_scan).color(Color.WHITE).sizeDp(24))
        return true
    }

}