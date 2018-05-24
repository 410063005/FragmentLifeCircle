package com.example.cm.demo_arch.livedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.example.cm.demo_arch.R
import kotlinx.android.synthetic.main.activity_live_data.*

/**
 * 演示了LiveData的用法
 *
 * Created by 410063005 on 2018/5/24.
 */
class LiveDataActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LiveDataActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        val model = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)
        model.resultList.observe(this, Observer {
            tvResult.text = it
        })

        etInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setInput(s ?: "")
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

}