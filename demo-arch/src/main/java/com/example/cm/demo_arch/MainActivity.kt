package com.example.cm.demo_arch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cm.demo_arch.codelabs.WordActivity
import com.example.cm.demo_arch.lifecycle.LifecycleOwnerActivity
import com.example.cm.demo_arch.livedata.LiveDataActivity
import com.example.cm.demo_arch.room.RoomActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRoom.setOnClickListener {
            RoomActivity.start(this)
        }

        btnViewModel.setOnClickListener {
            WordActivity.start(this)
        }

        btnLifecycle.setOnClickListener {
            LifecycleOwnerActivity.start(this)
        }

        btnLiveData.setOnClickListener {
            LiveDataActivity.start(this)
        }
    }
}
