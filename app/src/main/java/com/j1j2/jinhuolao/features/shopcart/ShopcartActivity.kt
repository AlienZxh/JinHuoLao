package com.j1j2.jinhuolao.features.shopcart

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.j1j2.common.base.BaseAdapter
import com.j1j2.jinhuolao.items.ShopcartItem
import org.jetbrains.anko.setContentView


/**
 * Created by albertz on 17-7-13.
 */
class ShopcartActivity : AppCompatActivity() {

    lateinit var baseAdapter: BaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseAdapter = BaseAdapter(arrayListOf(ShopcartItem(0), ShopcartItem(1), ShopcartItem(2)), this)
        ShopcartUI(baseAdapter).setContentView(this)
    }


}