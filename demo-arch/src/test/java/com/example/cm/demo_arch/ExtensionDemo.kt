package com.example.cm.demo_arch

/**
 * Created by kingcmchen on 2018/5/30.
 */

fun Int.cm() {
    println("$this")
}

fun String.toInt(): Int {
    return try {
        Integer.parseInt(this)
    } catch (e: Exception) {
        0
    }
}