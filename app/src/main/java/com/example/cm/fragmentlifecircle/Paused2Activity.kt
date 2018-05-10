package com.example.cm.fragmentlifecircle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_paused2.*

/**
 * Created by 410063005 on 2018/5/10.
 */
class Paused2Activity : AppCompatActivity() {

    companion object {
        val TAG = "Paused2Activity"
        fun start(context: Context) {
            context.startActivity(Intent(context, Paused2Activity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paused2)

        btnSendBroadcast.setOnClickListener {
            LocalBroadcastManager.getInstance(this)
                    .sendBroadcastSync(Intent("com.example.cm.fragmentlifecircle.aMessage"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}