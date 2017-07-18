package com.j1j2.jinhuolao.di

import android.support.v4.app.Fragment
import com.j1j2.jinhuolao.features.storehouse.StorehouseFragment
import com.j1j2.jinhuolao.features.storehouse.StorehouseView
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

/**
 * Created by albertz on 17-7-18.
 */
@Module
abstract class StorehouseModule {

    @Binds
    @IntoMap
    @FragmentKey(StorehouseFragment::class)
    abstract fun provideDetailFragmentFactory(builder: StorehouseComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    abstract fun provideStorehouseFragmentView(StorehouseFragment: StorehouseFragment): StorehouseView
}