package com.j1j2.jinhuolao.features.products

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.j1j2.common.widgets.BaseStatefulLayout
import org.jetbrains.anko.setContentView


/**
 * Created by albertz on 17-7-13.
 */
class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var ui = ProductsUI();
        ui.setContentView(this)
        ui.baseStatefulLayout.state = BaseStatefulLayout.BaseState.LOADING

    }

}