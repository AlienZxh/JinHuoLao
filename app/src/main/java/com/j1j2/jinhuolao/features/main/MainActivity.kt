package com.j1j2.jinhuolao.features.main

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import com.j1j2.jinhuolao.R
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

/**
 * Created by albertz on 17-7-13.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ui = MainUI()
        ui.setContentView(this)

        setSupportActionBar(ui.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_toolbar, menu)
        menu.findItem(R.id.qrscan).setIcon(IconicsDrawable(this).icon(CommunityMaterial.Icon.cmd_qrcode_scan).color(Color.WHITE).sizeDp(24))
        return true
    }

}