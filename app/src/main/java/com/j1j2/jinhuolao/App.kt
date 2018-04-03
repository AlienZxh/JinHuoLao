package com.j1j2.jinhuolao

import android.app.Application
import android.content.Context
import android.os.Environment
import android.support.multidex.MultiDex

import com.blankj.utilcode.util.EmptyUtils.isEmpty
import com.blankj.utilcode.util.ProcessUtils.getForegroundProcessName
import com.blankj.utilcode.util.Utils
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.squareup.leakcanary.RefWatcher

import com.tencent.bugly.beta.Beta
import com.tencent.bugly.BuglyStrategy

import com.tencent.bugly.Bugly
import com.alibaba.android.arouter.launcher.ARouter
import com.j1j2.jinhuolao.di.DaggerAppComponent
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.context.IconicsContextWrapper

import com.shizhefei.view.coolrefreshview.header.MaterialHeader
import com.shizhefei.view.coolrefreshview.PullHeader
import com.shizhefei.view.coolrefreshview.IPullHeaderFactory
import com.shizhefei.view.coolrefreshview.CoolRefreshView
import io.reactivex.ObservableSource
import com.mikepenz.iconics.Iconics




/**
 * Created by alienzxh on 17-6-22.
 */
open class App : DaggerApplication() {

    protected var processName: String? = null
    private lateinit var refWatcher: RefWatcher

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(IconicsContextWrapper.wrap(base));
        MultiDex.install(this)

    }

    fun debugInitObservable(): Iterable<ObservableSource<*>>? = null

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        initLeakCanary(this)
        initUtils(this)
        processName = getForegroundProcessName()
        if (!isEmpty(processName) && processName.equals(applicationContext.packageName)) {
            initBugly(this)
            initARouter(this)
            initCoolRefreshView()
        }
    }

    private fun initLeakCanary(context: Context) {
        refWatcher = if (BuildConfig.DEBUG) LeakCanary.install(context as Application) else RefWatcher.DISABLED
    }



    private fun initUtils(context: Context) {
        Utils.init(context)
    }

    private fun initBugly(context: Context) {
        Beta.autoInit = true
        Beta.autoCheckUpgrade = true
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)//设置sd卡的Download为更新资源存储目录
        val strategy = BuglyStrategy()
      
	    strategy.appChannel = if (BuildConfig.DEBUG) "jinhuolao-debug" else "jinhuolao"

        Bugly.init(context, Constants.BUGLY_ID, BuildConfig.DEBUG, strategy)
    }


    private fun initARouter(context: Context) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(context as Application)
    }

    private fun initCoolRefreshView() {
        CoolRefreshView.setPullHeaderFactory(object : IPullHeaderFactory {
            override fun made(context: Context): PullHeader {
                return MaterialHeader(context)
            }

            override fun isPinContent(): Boolean {
                return false
            }
        })
    }

    fun getRefWatcher(): RefWatcher = refWatcher


    override fun applicationInjector(): AndroidInjector<App> = DaggerAppComponent.builder().create(this@App)

}