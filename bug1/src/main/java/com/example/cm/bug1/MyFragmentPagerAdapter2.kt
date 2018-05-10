package com.example.cm.bug1

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by 410063005 on 2018/5/10.
 */
class MyFragmentPagerAdapter2(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return ChildFragment()

        }
        return null
    }

    override fun getCount(): Int {
        return 1
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "child0"
        }
        return ""
    }
}