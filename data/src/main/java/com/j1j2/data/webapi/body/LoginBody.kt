package com.j1j2.data.webapi.body

/**
 * Created by albertz on 17-7-4.
 */
data class LoginBody(val loginAccount: String, val passWord: String, val terminalType: Int = 1)