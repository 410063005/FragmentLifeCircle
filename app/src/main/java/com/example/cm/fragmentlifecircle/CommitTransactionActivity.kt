package com.example.cm.fragmentlifecircle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

/**
 * 举例说明commitAllowingStateLoss和commit的区别
 *
 * Created by 410063005 on 2018/5/10.
 */
class CommitTransactionActivity : AppCompatActivity() {

    companion object {
        val TAG = "CommitTransaction"

        fun start(context: Context) {
            context.startActivity(Intent(context, CommitTransactionActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commit_transaction)
        Log.d(TAG, "onCreate " + savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    private var mOn: Boolean = false

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")

        if (mOn) {
            supportFragmentManager
                    .beginTransaction().add(R.id.fl_fragment, ChildFragment.newInstance("commit-allowing-state-loss"))
                    .commitAllowingStateLoss()
            mOn = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    fun onBtnClick(view: View) {
        when (view.id) {
            R.id.btnCommit -> {
                supportFragmentManager
                        .beginTransaction().add(R.id.fl_fragment, ChildFragment.newInstance("commit"))
                        .commit()
            }
            R.id.btnCommitAllowingStateLoss -> {
                mOn = true
            }
        }
    }

    private fun mockHome() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addCategory(Intent.CATEGORY_HOME)
        startActivity(intent)
    }

}