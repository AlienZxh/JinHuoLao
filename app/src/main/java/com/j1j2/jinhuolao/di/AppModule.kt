package com.j1j2.jinhuolao.di

import android.content.Context
import com.j1j2.jinhuolao.App
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


/**
 * Created by zxh19 on 2017/6/25.
 */
@Module(subcomponents = arrayOf(LauncherComponent::class, MainComponent::class, CategoryComponent::class),
        includes = arrayOf(InteractorModule::class, UtilsModule::class))
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideContext(app: App): Context

}