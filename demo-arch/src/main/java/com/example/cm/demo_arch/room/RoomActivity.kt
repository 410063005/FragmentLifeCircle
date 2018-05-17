package com.example.cm.demo_arch.room

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cm.demo_arch.R
import kotlinx.android.synthetic.main.activity_room.*

/**
 * Created by 410063005 on 2018/5/16.
 */
class RoomActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, RoomActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        btnListAll.setOnClickListener {
            RoomListAllActivity.start(this)
        }

        btnAdd.setOnClickListener {
            RoomAddUserActivity.start(this)
        }
    }
}