package com.j1j2.jinhuolao.di

import com.j1j2.jinhuolao.features.storehouse.StorehouseFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by albertz on 17-7-18.
 */
@Subcomponent(modules = arrayOf(StorehouseModule::class))
interface StorehouseComponent : AndroidInjector<StorehouseFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<StorehouseFragment>()

}