package com.example.cm.demo_arch.codelabs

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import com.example.cm.demo_arch.R
import kotlinx.android.synthetic.main.activity_new_word.*

/**
 * Created by 410063005 on 2018/5/17.
 */
class NewWordActivity : AppCompatActivity() {

    companion object {
        val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"

        fun start(context: Context) {
            context.startActivity(Intent(context, NewWordActivity::class.java))
        }

        fun startForResult(activity: Activity, requestCode: Int) {
            activity.startActivityForResult(Intent(activity, NewWordActivity::class.java), requestCode)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        btnAdd.setOnClickListener {

            val reply = Intent()
            if (TextUtils.isEmpty(etNewWord.text)) {
                setResult(Activity.RESULT_CANCELED, reply)
            } else{
                reply.putExtra(EXTRA_REPLY, etNewWord.text.toString())
                setResult(Activity.RESULT_OK, reply)
            }
            finish()
        }
    }
}