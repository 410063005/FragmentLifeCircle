package com.example.cm.fragmentlifecircle

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_paused.*

/**
 * Created by 410063005 on 2018/5/10.
 */
class PausedActivity : AppCompatActivity() {

    companion object {
        val TAG = "PausedActivity"

        fun start(context: Context) {
            context.startActivity(Intent(context, PausedActivity::class.java))
        }
    }

    private val mBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            when (intent?.action) {
                // "com.example.cm.fragmentlifecircle.aMessage" -> showDialogFragment()
                "com.example.cm.fragmentlifecircle.aMessage" -> showDialogFragment()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paused)
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver,
                IntentFilter("com.example.cm.fragmentlifecircle.aMessage"))

        btnStartAnotherActivity.setOnClickListener {
            Paused2Activity.start(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver)
    }

    private fun showDialogFragment() {
        Log.d(TAG, "showDialogFragment")
        MyDialogFragment().show(supportFragmentManager, "dialog")
    }

    private fun showDialogFragmentFixed() {
        Log.d(TAG, "showDialogFragmentFixed")
        val f = MyDialogFragment()
        supportFragmentManager.beginTransaction().add(f, "dialog").commitAllowingStateLoss()
    }
}