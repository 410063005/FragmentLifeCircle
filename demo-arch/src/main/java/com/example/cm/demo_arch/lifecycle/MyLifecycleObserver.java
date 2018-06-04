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

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void test5() {
        Log.d(TAG, "test5: ON_CREATE");
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    public void test() {
//        Log.d(TAG, "test: ON_START");
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    public void test2() {
//        Log.d(TAG, "test2: ON_RESUME");
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    public void test1() {
//        Log.d(TAG, "test1: ON_RESUME");
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
//    public void test3() {
//        Log.d(TAG, "test3: ON_STOP");
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    public void test4() {
//        Log.d(TAG, "test4: ON_ANY");
//    }
}
