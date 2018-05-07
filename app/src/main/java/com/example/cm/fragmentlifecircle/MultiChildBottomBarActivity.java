package com.example.cm.fragmentlifecircle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * BottomBar的用法.
 *
 * Fragment的生命周期(多个Fragment).
 *
 * 一个简单的延迟加载demo.
 *
 * Created by 410063005 on 2018/5/7.
 */

public class MultiChildBottomBarActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    public static void start(Context context) {
        Intent starter = new Intent(context, MultiChildBottomBarActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_child_bottom_bar);

        mViewPager = findViewById(R.id.viewPager);
        FragmentPagerAdapter fpa = new MyFragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return ChildFragment.newLazyInstance("child0");
                } else if (position == 1) {
                    return ChildFragment.newLazyInstance("child1");
                } else if (position == 2) {
                    return ChildFragment.newLazyInstance("child2");
                }
                return null;
            }
        };
        mViewPager.setAdapter(fpa);
        mViewPager.setOffscreenPageLimit(2);

        final BottomNavigationView bnv = findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_favorites:
                        fun1("child1");
                        mViewPager.setCurrentItem(0);
                        break;

                    case R.id.action_schedules:
                        fun1("child2");
                        mViewPager.setCurrentItem(1);
                        break;

                    case R.id.action_music:
                        fun1("child3");
                        mViewPager.setCurrentItem(2);
                        break;

                }
                return true;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bnv.setSelectedItemId(R.id.action_favorites);
                        break;

                    case 1:
                        bnv.setSelectedItemId(R.id.action_schedules);
                        break;

                    case 2:
                        bnv.setSelectedItemId(R.id.action_music);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void fun1(String fragmentId) {
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, ChildFragment.newInstance(fragmentId)).commit();


    }
}
