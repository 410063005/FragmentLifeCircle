package com.example.cm.demo_arch;

import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.widget.Toast;

/**
 * Created by 410063005 on 2018/5/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleObserver() {

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public void hi() {
                Toast.makeText(App.this, "欢迎", Toast.LENGTH_SHORT).show();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public void bye() {
                Toast.makeText(App.this, "再见", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
