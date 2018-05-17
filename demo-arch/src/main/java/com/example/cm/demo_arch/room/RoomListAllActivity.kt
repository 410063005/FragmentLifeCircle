package com.example.cm.demo_arch.room

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.cm.demo_arch.AppDatabaseHolder
import com.example.cm.demo_arch.R
import kotlinx.android.synthetic.main.activity_room_list_all.*
import kotlin.concurrent.thread

/**
 * Created by 410063005 on 2018/5/16.
 */
class RoomListAllActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, RoomListAllActivity::class.java))
        }
    }

    private lateinit var userAdapter : RoomUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_list_all)

        userAdapter = RoomUserAdapter(this)
        //userAdapter.userList = listOf(User("c", "m"), User("a", "b"), User("c", "d"))
        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = userAdapter
        //userAdapter.notifyDataSetChanged()

        btnListAll.setOnClickListener {
            load()
        }
    }

    private fun load() {
        thread {
            val userList = AppDatabaseHolder.get(this).userDao().all
            btnListAll.post {
                userAdapter.userList.clear()
                userAdapter.userList.addAll(userList)
                userAdapter.notifyDataSetChanged()

                tvEmpty.visibility = View.GONE
            }
        }
    }
}