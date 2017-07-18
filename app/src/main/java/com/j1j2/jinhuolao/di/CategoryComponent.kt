package com.j1j2.jinhuolao.di

import android.support.v4.app.Fragment
import com.j1j2.jinhuolao.features.category.CategoryFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.android.support.FragmentKey


/**
 * Created by albertz on 17-7-18.
 */
@Subcomponent(modules = arrayOf(CategoryModule::class))
interface CategoryComponent : AndroidInjector<CategoryFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CategoryFragment>()

}