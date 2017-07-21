package com.j1j2.jinhuolao.di

import android.app.Activity
import com.j1j2.jinhuolao.features.category.CategoryActivity
import com.j1j2.jinhuolao.features.launcher.LauncherActivity
import com.j1j2.jinhuolao.features.main.MainActivity
import dagger.android.AndroidInjector
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module


/**
 * Created by zxh19 on 2017/6/25.
 */
@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(LauncherActivity::class)
     abstract fun bindLauncherActivity(builder: LauncherComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivity(builder: MainComponent.Builder): AndroidInjector.Factory<out Activity>


    @Binds
    @IntoMap
    @ActivityKey(CategoryActivity::class)
    abstract fun provideDetailFragmentFactory(builder: CategoryComponent.Builder): AndroidInjector.Factory<out Activity>
}