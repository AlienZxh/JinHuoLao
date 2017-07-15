package com.j1j2.data.interactor

import com.j1j2.data.webapi.AccountAPI
import com.j1j2.data.webapi.body.LoginBody
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by albertz on 17-7-5.
 */
class LogStateInteractor @Inject constructor(val accountAPI: AccountAPI, val logState: LogState) {


    fun login(loginBody: LoginBody): Observable<Boolean> = accountAPI.login(loginBody)
            .subscribeOn(Schedulers.io())
            .doOnSuccess { webReturn -> logState.login(webReturn.detail) }
            .doOnError { logState.loginout() }
            .map { webReturn -> webReturn.value }
            .toObservable()

}