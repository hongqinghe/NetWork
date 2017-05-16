package com.hongqing.network;

import android.os.Handler;
import android.os.Looper;

import com.hongqing.network.builder.GetBuilder;
import com.hongqing.network.cookies.SimpleCookieJar;


import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * Created by 逝世的岁月 on 2017/5/16.
 */

public class OkHttpUtils {
    private Handler looperHandler;
    private OkHttpClient mOkHttpClient;
    public  static  final  long DEFAULT_MILLISECONDS=1000;
    private boolean debug = false;
    private String mTag;

    private OkHttpUtils() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        //session是指请求和返回数据之间的交换
        //设置Cookie 用来创建和维护session的状态信息
        okHttpClientBuilder.cookieJar(new SimpleCookieJar());
        looperHandler = new Handler(Looper.getMainLooper());
        okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {

                return true;
            }
        });
        mOkHttpClient = okHttpClientBuilder.build();
    }

    public OkHttpUtils debug(String tag) {
        this.mTag = tag;
        debug = true;
        return this;
    }

    private static OkHttpUtils mOkHttpUtils;

    public static OkHttpUtils getInstance() {
        if (mOkHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                mOkHttpUtils = new OkHttpUtils();
            }
        }
        return mOkHttpUtils;
    }

    public Handler getLooperHandler() {
        return looperHandler;
    }

    public OkHttpClient getmOkHttpClient() {
        return mOkHttpClient;
    }
    //需要用到builder  get请求
   public  static GetBuilder get(){
       return  new GetBuilder();
   }

}
