package com.j1j2.common.base

import com.squareup.leakcanary.RefWatcher

/**
 * Created by albertz on 17-7-14.
 */
interface IRefWatch {
    fun getRefWatcher(): RefWatcher

}