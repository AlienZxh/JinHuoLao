package com.j1j2.jinhuolao.di

import com.j1j2.data.interactor.LogState
import com.j1j2.data.webapi.AccountAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by albertz on 17-7-5.
 */
@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideLoginAPI(retrofit: Retrofit): AccountAPI = retrofit.create(AccountAPI::class.java)

    @Provides
    @Singleton
    fun provideLogState(): LogState = LogState.instance


}