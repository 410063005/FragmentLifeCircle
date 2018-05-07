package com.example.cm.fragmentlifecircle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kingcmchen on 2018/5/7.
 */

public class MultiChildActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MultiChildActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_child);

        ViewPager vp = findViewById(R.id.viewPager);
        TabLayout tl = findViewById(R.id.tabLayout);
        FragmentPagerAdapter fpa = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(fpa);
        tl.setupWithViewPager(vp);
    }

    private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {

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
}
