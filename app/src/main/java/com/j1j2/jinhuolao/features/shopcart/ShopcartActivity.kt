package com.j1j2.jinhuolao.features.shopcart

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView


/**
 * Created by albertz on 17-7-13.
 */
class ShopcartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ShopcartUI().setContentView(this)
    }


}