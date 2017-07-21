package com.j1j2.jinhuolao.features.login


import android.os.Build
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import com.j1j2.common.widgets.attrAsDimen
import com.j1j2.jinhuolao.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.design.textInputLayout
import org.jetbrains.anko.design.themedAppBarLayout


/**
 * Created by albertz on 17-7-13.
 */
class LoginUI : AnkoComponent<AppCompatActivity> {
    lateinit var toolbar: Toolbar
    override fun createView(ui: AnkoContext<AppCompatActivity>): View {
        return with(ui) {
            verticalLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundResource = R.color.colorLayoutBackgroundLight
                
                themedAppBarLayout(theme = R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {

                    toolbar = themedToolbar(theme = R.style.AppTheme_AppBar_Light) {
                        popupTheme = R.style.AppTheme_Overlay_Light
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) elevation = dip(8).toFloat()

                        owner.setSupportActionBar(this@themedToolbar)
                    }.lparams(width = matchParent, height = ctx.attrAsDimen(R.attr.actionBarSize))

                }.lparams(width = matchParent, height = wrapContent)

                textInputLayout {
                    hint = "门店名称"
                    counterMaxLength = 20
                    include<TextInputEditText>(R.layout.view_textinputedittext_main) {
                        imeOptions = EditorInfo.IME_ACTION_NEXT
                        inputType = EditorInfo.TYPE_CLASS_TEXT
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = dip(8)
                    horizontalMargin = dip(16)
                }

                textInputLayout {
                    hint = "账号名称"
                    counterMaxLength = 20
                    include<TextInputEditText>(R.layout.view_textinputedittext_main) {
                        imeOptions = EditorInfo.IME_ACTION_NEXT
                        inputType = EditorInfo.TYPE_CLASS_TEXT
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    horizontalMargin = dip(16)
                }

                textInputLayout {
                    hint = "账号密码"
                    counterMaxLength = 20
                    include<TextInputEditText>(R.layout.view_textinputedittext_main) {
                        imeOptions = EditorInfo.IME_ACTION_DONE
                        inputType = EditorInfo.TYPE_TEXT_VARIATION_PASSWORD
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    horizontalMargin = dip(16)
                }

                include<Button>(R.layout.view_button_main) {
                    text = "登录"
                }.lparams(width = matchParent, height = dip(48)) {
                    topMargin = dip(8)
                    horizontalMargin = dip(16)
                }

                include<Button>(R.layout.view_button_blue) {
                    text = "注册"
                }.lparams(width = matchParent, height = dip(48)) {
                    topMargin = dip(8)
                    horizontalMargin = dip(16)
                }
            }
        }
    }
}

