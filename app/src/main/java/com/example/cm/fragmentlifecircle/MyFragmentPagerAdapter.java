package com.example.cm.fragmentlifecircle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by 410063005 on 2018/5/7.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final int COUNT = 3;

    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return ChildFragment.newInstance("child0");
        } else if (position == 1) {
            return ChildFragment.newInstance("child1");
        } else if (position == 2) {
            return ChildFragment.newInstance("child2");
        }
        return null;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return ("child0");
        } else if (position == 1) {
            return ("child1");
        } else if (position == 2) {
            return ("child2");
        }

        return super.getPageTitle(position);
    }
}
