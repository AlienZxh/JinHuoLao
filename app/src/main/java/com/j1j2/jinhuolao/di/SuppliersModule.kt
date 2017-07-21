package com.j1j2.jinhuolao.di

import android.support.v4.app.Fragment
import com.j1j2.jinhuolao.features.suppliers.SuppliersFragment
import com.j1j2.jinhuolao.features.suppliers.SuppliersView
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

/**
 * Created by albertz on 17-7-20.
 */
@Module
abstract class SuppliersModule {

    @Binds
    @IntoMap
    @FragmentKey(SuppliersFragment::class)
    abstract fun provideDetailFragmentFactory(builder: SuppliersComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    abstract fun provideSuppliersFragmentView(SuppliersFragment: SuppliersFragment): SuppliersView
}