package com.hongqing.network.request;

import com.hongqing.network.OkHttpUtils;
import com.hongqing.network.callback.Callback;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 逝世的岁月 on 2017/5/16.
 */

public class RequestCall {
    private OkHttpRequest okHttpRequest;
    private Request request;
    private Call call;
    private long readTimeOut;
    private long writeTimeOut;
    private long connTimeOut;
    private OkHttpClient okHttpClient;

    public RequestCall(OkHttpRequest request) {
        this.okHttpRequest = request;
    }

    public RequestCall readTimeOut(long readTimeOut) {
        this.readTimeOut = readTimeOut;
        return this;
    }

    public RequestCall writeTimeOut(long writeTimeOut) {
        this.writeTimeOut = writeTimeOut;
        return this;
    }

    public RequestCall connTimeOut(long connTimeOut) {
        this.connTimeOut = connTimeOut;
        return this;
    }

    public Call generateCall(Callback callBack) {
        request=generateRequest(callBack);
        if (readTimeOut >= 0 || writeTimeOut >= 0 || connTimeOut >= 0) {
            readTimeOut = readTimeOut >= 0 ? readTimeOut : OkHttpUtils.DEFAULT_MILLISECONDS;
            writeTimeOut = writeTimeOut >= 0 ? writeTimeOut : OkHttpUtils.DEFAULT_MILLISECONDS;
            connTimeOut = connTimeOut >= 0 ? connTimeOut : OkHttpUtils.DEFAULT_MILLISECONDS;

        okHttpClient = OkHttpUtils.getInstance().getmOkHttpClient().newBuilder()
                .readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeOut,TimeUnit.MILLISECONDS)
                .connectTimeout(connTimeOut,TimeUnit.MILLISECONDS)
                .build();
        call=okHttpClient.newCall(request);
        }else
        {
            call=OkHttpUtils.getInstance().getmOkHttpClient().newCall(request);
        }
        return call;
    }
   public  void execute(Callback callback){
       generateCall(callback);
       if (callback!=null){
           callback.onBefore(request);
       }
       //TODO
       OkHttpUtils.getInstance().execute();
   }
    private Request generateRequest(Callback callBack) {
        return okHttpRequest.generateRequest(callBack);
    }
}
