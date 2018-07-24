package com.example.demo_glide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.demo_glide.okhttploader.OkHttpGlideUrlLoaderActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPNG.setOnClickListener {
            PNGActivity.start(this, "http://igame-10037599.image.myqcloud.com/b8153781-3a33-4d0b-be09-a0e5063047c7")
        }
        buttonWebp.setOnClickListener {
            WebpActivity.start(this, "http://igame-10037599.image.myqcloud.com/b8153781-3a33-4d0b-be09-a0e5063047c7?imageView2/format/webp")
        }
        buttonOkHttp.setOnClickListener {
            OkHttpGlideUrlLoaderActivity.start(this)
        }
    }
}
