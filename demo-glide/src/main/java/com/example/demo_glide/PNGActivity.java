package com.example.demo_glide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class PNGActivity extends AppCompatActivity {

    public static void start(Context context, String url) {
        Intent starter = new Intent(context, PNGActivity.class);
        starter.putExtra("url", url);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_from_qcloud);

        String url = getIntent().getStringExtra("url");

        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load(url).apply(
                new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)).into(imageView);
    }
}
