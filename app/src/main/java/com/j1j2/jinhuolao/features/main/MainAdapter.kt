package com.j1j2.jinhuolao.features.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.j1j2.jinhuolao.features.personal.PersonalFragment
import com.j1j2.jinhuolao.features.storehouse.StorehouseFragment
import com.j1j2.jinhuolao.features.suppliers.SuppliersFragment

/**
 * Created by albertz on 17-7-18.
 */
class MainAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {



    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return StorehouseFragment()
            1 -> return SuppliersFragment()
            2 -> return PersonalFragment()
        }
        return Fragment()
    }

    override fun getCount(): Int = 3
}