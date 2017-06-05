package com.zlikun.jee;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 懒汉式单例，使用ReentrantLock实现，与双重检查机制存在同样问题(但个人测试感觉当前方式发生的几率似乎小一些)
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:27
 */
public class Singleton5 {

    private static final AtomicInteger COUNTER = new AtomicInteger() ;
    private static Singleton5 INSTANCE ;
    private static final ReentrantLock LOCK = new ReentrantLock() ;

    private Singleton5() {
        System.out.println(String.format("initialized - %03d" ,COUNTER.incrementAndGet()));
    }

    public static final Singleton5 getInstance() {
        if (INSTANCE == null) {
            try {
                // 尝试获取锁，没取到则等100毫秒，再往下走
                if (LOCK.tryLock(100 , TimeUnit.MILLISECONDS)) {
                    if (INSTANCE == null) {
                        INSTANCE = new Singleton5();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
        return INSTANCE ;
    }

}
