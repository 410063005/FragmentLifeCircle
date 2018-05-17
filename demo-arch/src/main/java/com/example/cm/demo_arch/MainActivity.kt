package com.example.cm.demo_arch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cm.demo_arch.codelabs.WordActivity
import com.example.cm.demo_arch.room.RoomActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        RoomActivity.start(this)
        WordActivity.start(this)
    }
}
