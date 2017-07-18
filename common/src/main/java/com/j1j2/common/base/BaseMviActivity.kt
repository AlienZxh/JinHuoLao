package com.j1j2.common.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.hannesdorfmann.mosby3.mvi.MviPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.j1j2.common.R

import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import dmax.dialog.SpotsDialog
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.setContentView
import javax.inject.Inject
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import com.blankj.utilcode.util.KeyboardUtils


/**
 * Created by albertz on 17-6-28.
 */
abstract class BaseMviActivity<UI : AnkoComponent<AppCompatActivity>, V : MvpView, P : MviPresenter<V, *>> : MviActivity<V, P>(), HasFragmentInjector, HasSupportFragmentInjector {
    protected val TAG = this.javaClass.simpleName

    @Inject
    internal lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    internal lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>

    private val progressDialog: SpotsDialog by lazy { SpotsDialog(this) }

    protected abstract fun createUI(): UI

    protected open fun initView(ui: UI) {

    }

    protected val ui: UI by lazy {
        createUI()
    }

    protected fun immersionBar(): ImmersionBar = ImmersionBar.with(this).statusBarColor(R.color.colorPrimaryDark).fitsSystemWindows(true)  //使用该属性必须指定状态栏的颜色，不然状态栏透明，很难看

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        immersionBar().init()
        ui.setContentView(this)
        initView(ui)
    }

    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy()
    }

    fun showLoadingDialog(message: CharSequence, cancelable: Boolean = false) {
        progressDialog.setMessage(message)
        progressDialog.setCancelable(cancelable)
        if (!progressDialog.isShowing()) progressDialog.show()
    }

    fun dismissLoadingDialog() {
        if (progressDialog.isShowing()) progressDialog.dismiss()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = this.supportFragmentInjector

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment> = this.frameworkFragmentInjector


    //region软键盘的处理____________________________________________________________________________________
    /**
     * 清除editText的焦点

     * @param v   焦点所在View
     * *
     * @param ids 输入框
     */
    fun clearViewFocus(v: View?, vararg ids: Int) {
        if (null != v && ids.isNotEmpty()) {
            for (id in ids) {
                if (v.getId() == id) {
                    v.clearFocus()
                    break
                }
            }
        }
    }

    /**
     * 隐藏键盘

     * @param v   焦点所在View
     * *
     * @param ids 输入框
     * *
     * @return true代表焦点在edit上
     */
    fun isFocusEditText(v: View?, vararg ids: Int): Boolean {
        if (null != v) {
            if (v is EditText) {
                val tmp_et = v
                if (ids.isNotEmpty()) {
                    for (id in ids) {
                        if (tmp_et.id == id) {
                            return true
                        }
                    }
                }
            }
        }

        return false
    }

    //是否触摸在指定view上面,对某个控件过滤
    fun isTouchView(views: Array<View>?, ev: MotionEvent): Boolean {
        if (views == null || views.isEmpty()) return false
        val location = IntArray(2)
        for (view in views) {
            view.getLocationOnScreen(location)
            val x = location[0]
            val y = location[1]
            if (ev.x > x && ev.x < x + view.getWidth()
                    && ev.y > y && ev.y < y + view.getHeight()) {
                return true
            }
        }
        return false
    }

    //是否触摸在指定view上面,对某个控件过滤
    fun isTouchView(ids: IntArray?, ev: MotionEvent): Boolean {
        val location = IntArray(2)
        if (null != ids && ids.isNotEmpty()) {
            for (id in ids) {
                val view = findViewById(id) ?: continue
                view.getLocationOnScreen(location)
                val x = location[0]
                val y = location[1]
                if (ev.x > x && ev.x < x + view.width
                        && ev.y > y && ev.y < y + view.height) {
                    return true
                }
            }
        }

        return false
    }
    //endregion

    //region 右滑返回上级
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            if (isTouchView(filterViewByIds(), ev)) return super.dispatchTouchEvent(ev)
            if (hideSoftByEditViewIds() == null || hideSoftByEditViewIds()!!.isEmpty())
                return super.dispatchTouchEvent(ev)
            val v = currentFocus
            if (isFocusEditText(v, *hideSoftByEditViewIds() ?: intArrayOf())) {
                if (isTouchView(hideSoftByEditViewIds(), ev))
                    return super.dispatchTouchEvent(ev)
                //隐藏键盘
                KeyboardUtils.hideSoftInput(this)
                clearViewFocus(v, *hideSoftByEditViewIds() ?: intArrayOf())

            }
        }
        return super.dispatchTouchEvent(ev)

    }

    /**
     * 传入EditText的Id
     * 没有传入的EditText不做处理

     * @return id 数组
     */
    open fun hideSoftByEditViewIds(): IntArray? {
        return null
    }

    /**
     * 传入要过滤的View
     * 过滤之后点击将不会有隐藏软键盘的操作

     * @return id 数组
     */
    open fun filterViewByIds(): Array<View>? {
        return null
    }
}