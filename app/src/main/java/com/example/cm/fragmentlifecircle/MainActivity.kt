package com.example.cm.fragmentlifecircle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onTextClick(view: View) {
        when (view.id) {
            R.id.textView -> SingleChildActivity.start(this)
            R.id.textView2 -> MultiChildActivity.start(this)
        }
    }
}
