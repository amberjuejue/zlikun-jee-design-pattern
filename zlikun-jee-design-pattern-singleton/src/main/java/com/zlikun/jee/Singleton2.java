package com.zlikun.jee;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉式单例，实际在并发环境存在问题
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:27
 */
public class Singleton2 {

    private static final AtomicInteger COUNTER = new AtomicInteger() ;
    private static Singleton2 INSTANCE ;

    public Singleton2() {
        System.out.println(String.format("initialized - %03d" ,COUNTER.incrementAndGet()));
    }

    public static final Singleton2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton2() ;
        }
        return INSTANCE ;
    }

}
