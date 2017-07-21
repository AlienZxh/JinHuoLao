package com.j1j2.jinhuolao.di

import com.j1j2.jinhuolao.features.main.MainActivity
import com.j1j2.jinhuolao.features.main.MainView
import dagger.Binds
import dagger.Module

/**
 * Created by albertz on 17-7-18.
 */
@Module(subcomponents = arrayOf(SuppliersComponent::class,PersonalComponent::class,StorehouseComponent::class))
abstract class MainModule {
    @Binds
    abstract fun provideLauncherView(mainActivity: MainActivity): MainView

}