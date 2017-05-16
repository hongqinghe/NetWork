package com.hongqing.network.cookies;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by 逝世的岁月 on 2017/5/16.
 */

public  final class SimpleCookieJar implements CookieJar {
    private List<Cookie> cookieList =new ArrayList<>();
    @Override
    public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
      cookies.addAll(cookies);
    }

    @Override
    public synchronized List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie>  loadForRequest=new ArrayList<>();
        for (Cookie  cookie:cookieList){
            if (cookie.matches(url)){
            loadForRequest.add(cookie);
            }
        }
        return loadForRequest;
    }
}
