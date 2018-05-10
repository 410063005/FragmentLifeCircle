package com.example.cm.bug1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText.setOnClickListener {
            SingleChildIMEActivity.start(this)
        }

        tvText2.setOnClickListener {
            AdjustPanActivity.start(this)
        }

        tvText3.setOnClickListener {
            AdjustResizeActivity.start(this)
        }

        tvText4.setOnClickListener {
            AdjustResizeTranslucentActivity.start(this)
        }
    }
}
