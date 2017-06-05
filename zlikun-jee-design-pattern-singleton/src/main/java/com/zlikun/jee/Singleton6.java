package com.zlikun.jee;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单实例的枚举本质上也是单例，且由虚拟机保证这一点
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:27
 */
public enum Singleton6 {

    INSTANCE ;

    final AtomicInteger COUNTER = new AtomicInteger() ;

    private Singleton6() {
        System.out.println(String.format("initialized - %03d" ,COUNTER.incrementAndGet()));
    }

}
