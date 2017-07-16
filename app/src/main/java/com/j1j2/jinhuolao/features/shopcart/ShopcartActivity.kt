package com.j1j2.jinhuolao.features.shopcart

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.ActionMode
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.j1j2.common.base.BaseAdapter
import com.j1j2.jinhuolao.R
import com.j1j2.jinhuolao.items.ShopcartItem
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.SelectableAdapter
import org.jetbrains.anko.setContentView


/**
 * Created by albertz on 17-7-13.
 */
class ShopcartActivity : AppCompatActivity(), ActionMode.Callback,
        FlexibleAdapter.OnItemClickListener, FlexibleAdapter.OnItemLongClickListener {

    lateinit var baseAdapter: BaseAdapter
    private var mActionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseAdapter = BaseAdapter(arrayListOf(ShopcartItem(0), ShopcartItem(1), ShopcartItem(2)), this)
        ShopcartUI(baseAdapter).setContentView(this)
    }

     override fun onSaveInstanceState(outState: Bundle) {
        baseAdapter.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore previous state
        if (savedInstanceState != null) {
            // Selection
            baseAdapter.onRestoreInstanceState(savedInstanceState)
            if (baseAdapter.getSelectedItemCount() > 0) {
                mActionMode = startSupportActionMode(this)
                setContextTitle(baseAdapter.getSelectedItemCount())
            }
        }
    }

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        return false
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        mode?.getMenuInflater()?.inflate(R.menu.shopcart_toolbar_action, menu)
        menu?.findItem(R.id.delete)?.setIcon(IconicsDrawable(this).icon(CommunityMaterial.Icon.cmd_delete).color(Color.WHITE).sizeDp(24))
        baseAdapter.setMode(SelectableAdapter.Mode.MULTI)
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return false
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        baseAdapter.setMode(SelectableAdapter.Mode.IDLE);
        baseAdapter.clearSelection()
        mActionMode = null;
    }

    override fun onItemClick(position: Int): Boolean {
        if (mActionMode != null && position != RecyclerView.NO_POSITION) {
            // Mark the position selected
            toggleSelection(position);
            return true;
        } else {

            return false;
        }
    }

    override fun onItemLongClick(position: Int) {
        if (mActionMode == null) {
            mActionMode = startSupportActionMode(this);
        }
        toggleSelection(position);
    }

    private fun toggleSelection(position: Int) {
        // Mark the position selected
        baseAdapter.toggleSelection(position)

        val count = baseAdapter.getSelectedItemCount()

        if (count == 0) {
            mActionMode?.finish()
        } else {
            setContextTitle(count)
        }
    }

    private fun setContextTitle(count: Int) {
        mActionMode?.setTitle(count.toString() + "项被选中")
    }
}