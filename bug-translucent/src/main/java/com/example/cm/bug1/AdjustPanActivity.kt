package com.example.cm.bug1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_single_child_ime.*

/**
 * Created by 410063005 on 2018/5/10.
 */
class AdjustPanActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, AdjustPanActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "AdjustPanActivity"
        setContentView(R.layout.activity_single_child_ime)

        tvMessage.text = "windowSoftInputMode=\"adjustPan\" EditText可以跟随软键盘 但软键盘打开时action bar不可见"

        val a = MyFragmentPagerAdapter2(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = a
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }
}