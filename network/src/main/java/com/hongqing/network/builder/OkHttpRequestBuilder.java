package com.hongqing.network.builder;

import com.hongqing.network.request.RequestCall;

import java.util.Map;

/**
 * Created by 逝世的岁月 on 2017/5/16.
 */

public abstract class OkHttpRequestBuilder {
    protected String url;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;
    public abstract OkHttpRequestBuilder url(String url);
    public abstract OkHttpRequestBuilder tag(Object tag);
    public abstract OkHttpRequestBuilder headers(Map<String ,String> headers);
    public  abstract OkHttpRequestBuilder addHeaders(String key,String val);
    public  abstract  OkHttpRequestBuilder params(Map<String ,String> params);
    public abstract OkHttpRequestBuilder addParams(String key,String val);
    public abstract RequestCall build();
}
