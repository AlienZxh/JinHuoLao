package com.j1j2.jinhuolao.di

import com.j1j2.jinhuolao.features.personal.PersonalFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by albertz on 17-7-18.
 */
@Subcomponent(modules = arrayOf(PersonalModule::class))
interface PersonalComponent : AndroidInjector<PersonalFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<PersonalFragment>()
}