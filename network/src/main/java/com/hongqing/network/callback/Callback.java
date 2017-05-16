package com.hongqing.network.callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 逝世的岁月 on 2017/5/16.
 */

public abstract class Callback <T>{
    /**
     * UI
     * @param request
     */
    public void onBefore(Request request) {

    }

    /**
     * UI
     */
    public void onAfter() {

    }

    /**
     * UI
     * @param progress
     */
    public void inProgress(float progress) {

    }
    public  abstract  T parseNetworkResponse(Response  response) throws  Exception;
    public  abstract void onError(Call call,Exception e);
    public  abstract void onResponse(T response);
    public static Callback CALLBACK_DEFAULT=new Callback() {
        @Override
        public Object parseNetworkResponse(Response response) throws Exception {
            return null;
        }

        @Override
        public void onError(Call call, Exception e) {

        }

        @Override
        public void onResponse(Object response) {

        }
    };
}
