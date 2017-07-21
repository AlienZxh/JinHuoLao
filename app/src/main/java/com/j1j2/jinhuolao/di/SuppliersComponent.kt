package com.j1j2.jinhuolao.di

import com.j1j2.jinhuolao.features.suppliers.SuppliersFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by albertz on 17-7-20.
 */
@Subcomponent(modules = arrayOf(SuppliersModule::class))
interface SuppliersComponent: AndroidInjector<SuppliersFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SuppliersFragment>()

}