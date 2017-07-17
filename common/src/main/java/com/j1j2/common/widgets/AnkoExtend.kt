package com.j1j2.common.widgets

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

import android.content.res.TypedArray
import android.support.annotation.AttrRes
import android.support.annotation.StyleRes
import android.support.v7.view.ContextThemeWrapper
import android.util.TypedValue
import android.view.View
import android.view.ViewManager
import android.widget.Button
import android.widget.TextView
import com.mikepenz.iconics.view.IconicsTextView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals


/**
 * Created by albertz on 17-7-7.
 */
fun Context.attribute(value: Int): TypedValue {
    var ret = TypedValue()
    getTheme().resolveAttribute(value, ret, true)
    return ret
}

fun Context.attrAsDimen(value: Int): Int {
    return TypedValue.complexToDimensionPixelSize(attribute(value).data, getResources().getDisplayMetrics())
}

fun wrapContextIfNeeded(ctx: Context, @StyleRes theme: Int): Context {
    return if (theme != 0 && (ctx !is ContextThemeWrapper || ctx.themeResId != theme)) {
        // If the context isn't a ContextThemeWrapper, or it is but does not have
        // the same theme as we need, wrap it in a new wrapper
        ContextThemeWrapper(ctx, theme)
    } else {
        ctx
    }
}


@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.baseStatefulLayout() = baseStatefulLayout(init = {})

inline fun ViewManager.baseStatefulLayout(init: BaseStatefulLayout.() -> Unit): BaseStatefulLayout {
    return ankoView({ BaseStatefulLayout(it) }, theme = 0, init = init)
}






