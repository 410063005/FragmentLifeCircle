package com.example.demo_glide.okhttploader;

import android.util.Log;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Synthetic;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class OkHttpStreamFetcher implements DataFetcher<InputStream> {

    private static final String TAG = "OkHttpStreamFetcher";

    private final OkHttpClient client;
    private final GlideUrl url;

    private InputStream inputStream;
    private volatile Call call;
    @Synthetic
    private
    ResponseBody responseBody;

    public OkHttpStreamFetcher(OkHttpClient client, GlideUrl url) {
        this.client = client;
        this.url = url;
    }


    @Override
    public void loadData(Priority priority, final DataCallback<? super InputStream> callback) {
        Request.Builder requestBuilder = new Request.Builder().url(url.toStringUrl());
        for (Map.Entry<String, String> headerEntry : url.getHeaders().entrySet()) {
            String key = headerEntry.getKey();
            requestBuilder.addHeader(key, headerEntry.getValue());
        }
        final Request request = requestBuilder.build();

        call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (Log.isLoggable(TAG, Log.DEBUG)) {
                    Log.d(TAG, "onFailure: OkHttp failed to obtain result", e);
                }
                callback.onLoadFailed(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                responseBody = response.body();
                if (response.isSuccessful()) {
                    long contentLength = responseBody.contentLength();

                    if (Log.isLoggable(TAG, Log.DEBUG)) {
                        Log.d(TAG, "onResponse: contentLength=" + contentLength);
                    }

                    inputStream = ContentLengthInputStream.obtain(responseBody.byteStream(), contentLength);
                    callback.onDataReady(inputStream);
                } else {
                    callback.onLoadFailed(new HttpException(response.message(), response.code()));
                }
            }
        });
    }

    @Override
    public void cleanup() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                // IGNORE
            }
        }
        if (responseBody != null) {
            try {
                responseBody.close();
            } catch (IOException e) {
                // IGNORE
            }
        }
    }

    @Override
    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}
