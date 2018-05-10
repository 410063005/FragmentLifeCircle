package com.example.cm.bug1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * 复现项目中遇到的一个跟输入法相关的问题.
 *
 * Created by 410063005 on 2018/5/8.
 */

public class SingleChildIMEActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, SingleChildIMEActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_child_ime);
        setTitle("最终修复版本");
        StatusBarUtil.transparentAndCoverStatusBar(this);
        StatusBarUtil.setColorNoTranslucent(this, ContextCompat.getColor(this, R.color.colorPrimary));

        ((TextView) findViewById(R.id.tvMessage)).setText("最终的修复版本， 透明状态栏， EditText可以完美跟随软键盘");

        MyFragmentPagerAdapter a = new MyFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(a);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }


}
