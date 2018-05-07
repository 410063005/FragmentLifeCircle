package com.example.cm.fragmentlifecircle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

/**
 * FragmentTabHost的用法.
 *
 * Fragment的生命周期(嵌套的Fragment).
 *
 * Created by 410063005 on 2018/5/7.
 */
// TODO: 2018/5/7  
public class NestChildActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, NestChildActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_child);

        FragmentTabHost fth = findViewById(android.R.id.tabcontent);
        fth.setup(this, getSupportFragmentManager());

        TabHost.TabSpec t1 = fth.newTabSpec("child1").setIndicator("Child1");
        fth.addTab(t1, ChildFragment.class, ChildFragment.args("child1"));
        TabHost.TabSpec t2 = fth.newTabSpec("child2").setIndicator("Child2");
        fth.addTab(t2, ChildFragment.class, ChildFragment.args("child2"));
        TabHost.TabSpec t3 = fth.newTabSpec("child3").setIndicator("Child3");
        fth.addTab(t3, ChildFragment.class, ChildFragment.args("child3"));
    }
}
