package com.j1j2.jinhuolao.di


import com.j1j2.jinhuolao.features.launcher.LauncherActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


/**
 * Created by zxh19 on 2017/6/25.
 */

@Subcomponent(modules = arrayOf(LauncherModule::class))
interface LauncherComponent : AndroidInjector<LauncherActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<LauncherActivity>()

}
