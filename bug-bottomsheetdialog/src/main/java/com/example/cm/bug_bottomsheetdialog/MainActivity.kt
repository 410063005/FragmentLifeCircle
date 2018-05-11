package com.example.cm.bug_bottomsheetdialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvShowDialog.setOnClickListener {
            MyBottomSheetDialog.newInstance(R.layout.fragment_my_bottom_dialog).show(supportFragmentManager, "dialog")
        }

        tvShowDialog2.setOnClickListener {
            MyBottomSheetDialog.newInstance(R.layout.fragment_my_bottom_dialog_fixed).show(supportFragmentManager, "dialog")
        }
    }
}
