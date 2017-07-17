package com.j1j2.common.widgets

import android.content.Context
import android.support.transition.TransitionManager
import android.support.v4.view.LayoutInflaterCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import com.j1j2.common.R
import com.j1j2.common.views.StateEmptyViewUI
import com.mikepenz.iconics.context.IconicsLayoutInflater
import cz.kinst.jakub.view.StatefulLayout
import org.jetbrains.anko.AnkoContext


/**
 * Created by albertz on 17-7-17.
 */
class BaseStatefulLayout : StatefulLayout {

    var mInitialState: String = BaseState.CONTENT
    var isTransitionsEnabled: Boolean = true

    constructor(context: Context?) : super(context) {
        init(context!!)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context!!)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context!!)
    }

    override fun onSetupContentState() {
        super.onSetupContentState()
        state = mInitialState
    }

    override fun setState(state: String) {
        if (isTransitionsEnabled)
            TransitionManager.beginDelayedTransition(this)
        super.setState(state)
    }


    private fun init(context: Context) {
        val layoutInflater = LayoutInflater.from(getContext());


//        setStateView(BaseState.EMPTY,  StateEmptyViewUI().createView(AnkoContext.Companion.create(context,false)))
        setStateView(BaseState.EMPTY,  layoutInflater.inflate(R.layout.view_state_empty, null,false))
        setStateView(BaseState.LOADING, layoutInflater.inflate(R.layout.view_state_loading, null,false))
        setStateView(BaseState.ERROR, layoutInflater.inflate(R.layout.view_state_error, null,false))

    }


    class BaseState {
        companion object {
            // Note: CONTENT state is inherited from parent
            val LOADING = "loading"
            val EMPTY = "empty"
            val ERROR = "error"
            val CONTENT = "content"
        }
    }

}