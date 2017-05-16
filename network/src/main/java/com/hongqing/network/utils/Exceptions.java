package com.hongqing.network.utils;

/**
 * Created by 逝世的岁月 on 2017/5/16.
 */

public class Exceptions {
    //参数异常
    public static void illegalArgument(String msg){
        throw new IllegalArgumentException(msg);
    }
}
