package com.example.cm.demo_arch.room

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import com.example.cm.demo_arch.AppDatabaseHolder
import com.example.cm.demo_arch.R
import kotlinx.android.synthetic.main.activity_room_add.*
import kotlin.concurrent.thread

/**
 * Created by 410063005 on 2018/5/16.
 */
class RoomAddUserActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, RoomAddUserActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_add)

        btnAdd.setOnClickListener {
            val firstName = etFirstName.text?.toString()
            val lastName = etLastName.text?.toString()

            if (TextUtils.isEmpty(firstName)) {
                etFirstName.error = "名字不能为空"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(lastName)) {
                etLastName.error = "姓氏不能为空"
                return@setOnClickListener
            }

            val user = User()
            user.firstName = firstName
            user.lastName = lastName

            thread {
                AppDatabaseHolder.get(this).userDao().insertAll(user)
                btnAdd.post {
                    Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}