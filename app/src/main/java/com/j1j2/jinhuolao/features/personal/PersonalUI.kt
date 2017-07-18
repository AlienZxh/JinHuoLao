package com.j1j2.jinhuolao.features.personal

import android.support.v4.app.Fragment
import android.view.View
import com.j1j2.jinhuolao.R
import org.jetbrains.anko.*

/**
 * Created by albertz on 17-7-13.
 */
class PersonalUI : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>): View {
        return with(ui) {
            frameLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.material_blue_500


            }
        }
    }
}