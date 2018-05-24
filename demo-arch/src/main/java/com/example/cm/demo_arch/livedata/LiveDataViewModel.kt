package com.example.cm.demo_arch.livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations.map
import android.arch.lifecycle.Transformations.switchMap
import android.arch.lifecycle.ViewModel

/**
 * Created by 410063005 on 2018/5/24.
 */
class LiveDataViewModel : ViewModel() {

    private val input = MutableLiveData<String>()

    private val upperCastInput = map(input, { it.toUpperCase() })

    private val result = switchMap(upperCastInput, { foo(it) })

    val resultList = switchMap(result, { foo2(it) })!!

    fun setInput(input: CharSequence) {
        if (this.input.value == input) {
            return
        }
        this.input.value = input.toString()
    }

    fun foo(it: String): LiveData<CharArray> {
        val r = MutableLiveData<CharArray>()
        r.value = it.toCharArray()
        return r
    }

    fun foo2(it: CharArray): LiveData<String> {
        val r = MutableLiveData<String>()
        var s = it.joinToString(separator = ",")
        s = "size is ${s.length}, content is $s"
        r.value = s
        return r
    }
}