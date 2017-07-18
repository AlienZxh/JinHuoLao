package com.j1j2.jinhuolao.di

import android.support.v4.app.Fragment
import com.j1j2.jinhuolao.features.personal.PersonalFragment
import com.j1j2.jinhuolao.features.personal.PersonalView
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
abstract class PersonalModule {

    @Binds
    @IntoMap
    @FragmentKey(PersonalFragment::class)
    abstract fun provideDetailFragmentFactory(builder: PersonalComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    abstract fun providePersonalFragmentView(PersonalFragment: PersonalFragment): PersonalView
}