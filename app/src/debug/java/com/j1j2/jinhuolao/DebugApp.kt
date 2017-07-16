package com.j1j2.jinhuolao

import android.content.Context
import com.blankj.utilcode.util.EmptyUtils
import com.facebook.stetho.Stetho
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.utils.Log


/**
 * Created by zxh19 on 2017/6/25.
 */
class DebugApp : App() {
    override fun onCreate() {
        super.onCreate()
        if (!EmptyUtils.isEmpty(processName) && processName.equals(applicationContext.packageName)) {
            initFlexibleAdapter()
            initStetho(this)
        }

    }

    private fun initStetho(context: Context) {
        Stetho.initializeWithDefaults(context)
    }

    private fun initFlexibleAdapter() {
        FlexibleAdapter.enableLogs(Log.Level.VERBOSE)
    }
}