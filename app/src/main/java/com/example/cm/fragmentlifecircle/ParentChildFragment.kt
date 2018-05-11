package com.example.cm.fragmentlifecircle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by 410063005 on 2018/5/11.
 */
class ParentChildFragment : Fragment() {

    companion object {
        val TAG = "ParentChildFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_parent_child, container, false)
    }
}