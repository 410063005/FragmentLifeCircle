package com.example.cm.bug.rv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = BadAdapter()
//        val adapter = GoodAdapter()
        recyclerView.adapter = adapter

        var count = 100
        adapter.timerItemList =
                generateSequence {
                    if (count-- > 99) TimerItem(count) else null
                }.toList()

    }
}
