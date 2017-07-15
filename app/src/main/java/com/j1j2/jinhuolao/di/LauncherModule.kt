package com.j1j2.jinhuolao.di



import com.j1j2.jinhuolao.features.launcher.LauncherActivity
import com.j1j2.jinhuolao.features.launcher.LauncherView
import dagger.Binds
import dagger.Module


/**
 * Created by zxh19 on 2017/6/25.
 */
@Module
abstract class LauncherModule {

    @Binds
    abstract fun provideLauncherView(launcherActivity: LauncherActivity): LauncherView


}