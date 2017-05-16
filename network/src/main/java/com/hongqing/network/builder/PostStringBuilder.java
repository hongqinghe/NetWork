package com.hongqing.network.builder;

import android.content.Context;

import com.hongqing.network.request.RequestCall;

import java.util.Map;

import okhttp3.MediaType;

/**
 * Created by 逝世的岁月 on 2017/5/16.
 */

public class PostStringBuilder extends OkHttpRequestBuilder {
    private MediaType mediaType;
private  String content;

    public PostStringBuilder content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public OkHttpRequestBuilder url(String url) {
        return null;
    }

    @Override
    public OkHttpRequestBuilder tag(Object tag) {
        return null;
    }

    @Override
    public OkHttpRequestBuilder headers(Map<String, String> headers) {
        return null;
    }

    @Override
    public OkHttpRequestBuilder addHeaders(String key, String val) {
        return null;
    }

    @Override
    public OkHttpRequestBuilder params(Map<String, String> params) {
        return null;
    }

    @Override
    public OkHttpRequestBuilder addParams(String key, String val) {
        return null;
    }

    @Override
    public RequestCall build() {
        return null;
    }
}
