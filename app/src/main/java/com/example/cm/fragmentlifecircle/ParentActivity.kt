package com.example.cm.fragmentlifecircle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * https://www.youtube.com/watch?v=WVPH48lUzGY 11:00 左右提出这样一个问题
 *
 * Does a child fragment's onCreate run before or after it's parent?
 *
 * Created by 410063005 on 2018/5/11.
 */
class ParentActivity : AppCompatActivity() {

    companion object {
        val TAG = "ParentActivity"

        fun start(context: Context) {
            context.startActivity(Intent(context, ParentActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        Log.d(TAG, "onCreate")
    }
}