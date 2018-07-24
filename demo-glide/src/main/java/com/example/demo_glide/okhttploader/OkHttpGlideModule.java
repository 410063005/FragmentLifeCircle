package com.example.demo_glide.okhttploader;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

@GlideModule
public class OkHttpGlideModule extends AppGlideModule {

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpGlideUrlLoader.Factory());
    }

    @Override
    public boolean isManifestParsingEnabled() {
        //return super.isManifestParsingEnabled();
        return false;
    }
}
