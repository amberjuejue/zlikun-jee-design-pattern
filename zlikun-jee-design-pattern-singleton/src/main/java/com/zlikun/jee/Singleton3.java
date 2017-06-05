package com.zlikun.jee;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉式单例，使用双重检查锁，并发下也不会出现多个实例情况
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:27
 */
public class Singleton3 {

    private static final AtomicInteger COUNTER = new AtomicInteger() ;
    private static Singleton3 INSTANCE ;

    private Singleton3() {
        System.out.println(String.format("initialized - %03d" ,COUNTER.incrementAndGet()));
    }

    public static final Singleton3 getInstance() {
        if (INSTANCE == null) {
            // 使用双重检查，并且使用同步锁以规避并发下重复执行问题
            // 实际情况是，由Java内存模型(指令重排序)，造成存在一定几率，即使使用了双重检查，仍出现了多个实际情况，可以通过多次执行`Singleton3Test`测试来证明该问题
            synchronized (Singleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton3() ;
                }
            }
        }
        return INSTANCE ;
    }

}
