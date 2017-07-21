package com.j1j2.jinhuolao.di

import com.j1j2.jinhuolao.features.category.CategoryActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


/**
 * Created by albertz on 17-7-18.
 */
@Subcomponent(modules = arrayOf(CategoryModule::class))
interface CategoryComponent : AndroidInjector<CategoryActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CategoryActivity>()

}