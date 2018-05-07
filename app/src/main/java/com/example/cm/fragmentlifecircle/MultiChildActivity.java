package com.example.cm.fragmentlifecircle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * TabLayout的用法.
 *
 * Created by 410063005 on 2018/5/7.
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
}
