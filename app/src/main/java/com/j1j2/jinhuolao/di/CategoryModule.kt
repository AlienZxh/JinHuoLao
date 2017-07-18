package com.j1j2.jinhuolao.di

import android.support.v4.app.Fragment
import com.j1j2.jinhuolao.features.category.CategoryFragment
import com.j1j2.jinhuolao.features.category.CategoryView
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
abstract class CategoryModule {

    @Binds
    @IntoMap
    @FragmentKey(CategoryFragment::class)
    abstract fun provideDetailFragmentFactory(builder: CategoryComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    abstract fun provideCategoryFragmentView(categoryFragment: CategoryFragment): CategoryView
}