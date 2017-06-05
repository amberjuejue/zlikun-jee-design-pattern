package com.zlikun.jee;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 饿汉式单例
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:22
 */
public class Singleton0 {

    private static final AtomicInteger COUNTER = new AtomicInteger() ;
    private static Singleton0 INSTANCE = new Singleton0() ;

    private Singleton0() {
        System.out.println(String.format("initialized - %03d" ,COUNTER.incrementAndGet()));
    }

    public static final Singleton0 getInstance() {
        return INSTANCE ;
    }

}
