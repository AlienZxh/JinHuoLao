package com.j1j2.jinhuolao.features.launcher

/**
 * Created by albertz on 17-6-29.
 */
sealed class LauncherViewState{
    class LoginStateView : LauncherViewState()
    class LogoutStateView : LauncherViewState()
}

