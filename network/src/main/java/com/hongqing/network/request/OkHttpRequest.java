package com.hongqing.network.request;

import com.hongqing.network.callback.Callback;
import com.hongqing.network.utils.Exceptions;

import java.util.Map;


import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.framed.Header;

/**
 * Created by 逝世的岁月 on 2017/5/16.
 */

public abstract class OkHttpRequest {
    protected String url;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected Request.Builder builder = new Request.Builder();

    protected OkHttpRequest(String url, Object tag, Map<String, String> headers, Map<String, String> params) {
        this.url = url;
        this.tag = tag;
        this.headers = headers;
        this.params = params;
        if (url == null) {
            Exceptions.illegalArgument("url can't null");
        }
    }

    protected abstract RequestBody builderRequestBody();

    protected RequestBody wrapRequesBody(RequestBody requestBody, Callback callback) {
        return requestBody;
    }

    protected abstract Request buildRequest(Request.Builder builder, RequestBody requestBody);

    public RequestCall build() {
        return new RequestCall(this);
    }

    public Request generateRequest(Callback callback) {
        RequestBody requestBody = wrapRequesBody(builderRequestBody(), callback);
        prepareBuilder();
        return buildRequest(builder, requestBody);
    }

    private void prepareBuilder() {
        builder.url(url).tag(tag);
        appendHeaders();
    }

    private void appendHeaders() {
        Headers.Builder headersBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) {
            return;
        }
        for (String key : headers.keySet()) {
            headersBuilder.add(key, headers.get(key));

        }
        builder.headers(headersBuilder.build());
    }

    @Override
    public String toString() {
        return "OkHttpRequest{" +
                "url='" + url + '\'' +
                ", tag=" + tag +
                ", headers=" + headers +
                ", params=" + params +
                '}';
    }
}