package com.example.demo_glide.okhttploader;

import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;

public class OkHttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    private final OkHttpClient client;

    public OkHttpGlideUrlLoader(OkHttpClient client) {
        this.client = client;
    }


    @Nullable
    @Override
    public LoadData<InputStream> buildLoadData(GlideUrl glideUrl, int width, int height, Options options) {
        return new LoadData<>(glideUrl, new OkHttpStreamFetcher(client, glideUrl));
    }

    @Override
    public boolean handles(GlideUrl glideUrl) {
        return true;
    }

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        private OkHttpClient client;

        public Factory() {
            client = new OkHttpClient();
        }

        @Override
        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiFactory) {
            return new OkHttpGlideUrlLoader(client);
        }

        @Override
        public void teardown() {
            // NO OP
        }
    }
}