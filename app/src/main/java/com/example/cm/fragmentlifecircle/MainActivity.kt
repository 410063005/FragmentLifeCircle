package com.example.cm.fragmentlifecircle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

/**
 * 入口.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onTextClick(view: View) {
        when (view.id) {
            R.id.textView -> SingleChildActivity.start(this)
            R.id.textView2 -> MultiChildActivity.start(this)
            R.id.textView3 -> NestChildActivity.start(this)
            R.id.textView4 -> MultiChildBottomBarActivity.start(this)
            R.id.textView5 -> CommitTransactionActivity.start(this)
            R.id.textView6 -> PausedActivity.start(this)
            R.id.textView7 -> ParentActivity.start(this)
        }
    }
}
