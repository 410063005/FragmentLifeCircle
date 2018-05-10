package com.example.cm.bug1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_single_child_ime.*

/**
 * Created by 410063005 on 2018/5/10.
 */
class AdjustResizeTranslucentActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, AdjustResizeTranslucentActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_child_ime)
        StatusBarUtil.transparentAndCoverStatusBar(this)
        StatusBarUtil.setColorNoTranslucent(this, ContextCompat.getColor(this, R.color.colorPrimary))

        btnFitSystemWindows.visibility = View.VISIBLE
        btnFitSystemWindows.setOnClickListener {
            cl_root.fitsSystemWindows = !cl_root.fitsSystemWindows
            val param = tvMessage.layoutParams as ConstraintLayout.LayoutParams?
            if (cl_root.fitsSystemWindows) {
                param?.topMargin = 0
                btnFitSystemWindows.text = "fit=true"
            } else {
                param?.topMargin = (90 * resources.displayMetrics.density).toInt()
                btnFitSystemWindows.text = "fit=false"
            }
            tvMessage.layoutParams = param
        }

        tvMessage.text = "透明状态栏，windowSoftInputMode=\"adjustResize\" 软键盘打开时EditText被遮挡\n这个是Android的bug 解决办法是布局的根节点中添加fitsSystemWindows=true"

        title = "AdjustResizeTranslucentActivity"
        val a = MyFragmentPagerAdapter2(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = a
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }
}