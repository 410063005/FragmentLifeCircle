package com.example.cm.demo_arch.lifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 410063005 on 2018/5/17.
 */

public class LifecycleOwnerActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, LifecycleOwnerActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new MyLifecycleObserver());
    }
}
