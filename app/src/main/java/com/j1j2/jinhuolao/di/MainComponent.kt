package com.j1j2.jinhuolao.di

import com.j1j2.jinhuolao.features.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by albertz on 17-7-18.
 */
@Subcomponent(modules = arrayOf(MainModule::class, CategoryModule::class,PersonalModule::class,StorehouseModule::class))
interface MainComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}