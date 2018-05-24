package com.example.cm.demo_arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 *
 *
 * Created by 410063005 on 2018/5/17.
 */

public class MyLifecycleObserver implements LifecycleObserver {

    private static final String TAG = "MyLifecycleObserver";


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void test2() {
        Log.d(TAG, "test2: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void test1() {
        Log.d(TAG, "test1: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void test3() {
        Log.d(TAG, "test3: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void test4() {
        Log.d(TAG, "test4: ");
    }
}
