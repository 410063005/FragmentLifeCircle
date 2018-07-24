package com.example.demo_glide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.RequestOptions;

public class TargetActivity extends AppCompatActivity {

    private LruBitmapPool mPool = new LruBitmapPool(10 * 1024 * 1024);

    private Bitmap mBitmap;
    private CheckBox mCheckBox;

    private String[] mUrls = new String[]{
            "http://igame-10037599.image.myqcloud.com/b8153781-3a33-4d0b-be09-a0e5063047c7?imageView2/format/webp",
            "http://igame-10037599.image.myqcloud.com/f875dcc2-14d0-481d-82e8-cf95c81affae",
            "http://igame-10037599.image.myqcloud.com/265e13ab-01fd-41d8-9030-cda5df8aaf7f",
            "http://igame-10037599.image.myqcloud.com/7d6dd95e-0939-4977-ac00-a082bc7d4f7a",
            "http://cross.store.qq.com/cross/6cbbe5db2ffc7f1965097b54779a17d238773d29fa68e0b49fc209146d44b72e0c82820496abac62/"
    };
    private int mIndex;

    public static void start(Context context) {
        Intent starter = new Intent(context, TargetActivity.class);
        context.startActivity(starter);
    }

    private static final String FRAGMENT_TAG = "com.bumptech.glide.manager";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = findViewById(R.id.imageView);
                GlideUrl glideUrl = new GlideUrl("http://cross.store.qq.com/cross/6cbbe5db2ffc7f1965097b54779a17d238773d29fa68e0b49fc209146d44b72e0c82820496abac62/");
                Glide.with(TargetActivity.this).load(glideUrl).apply(new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)).into(imageView);

            }
        });
    }


}
