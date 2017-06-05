package com.zlikun.jee;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉式单例，使用内部类来实现懒汉式单例
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:27
 */
public class Singleton4 {

    private static final AtomicInteger COUNTER = new AtomicInteger() ;
    private static Singleton4 INSTANCE ;

    private Singleton4() {
        System.out.println(String.format("initialized - %03d" ,COUNTER.incrementAndGet()));
    }

    static class Singleton4Holder {
        // 在Singleton4Holder被实例化之前，obj实例不会被初始化，由于其为静态变量，所以无论Singleton4Holder产生多少个实例，都共享同一个obj对象
        // 所以该方式仍能保证外部类实例在需要时才初始化，且全局惟一，对于较小的类该方法并不适用(虽然没有初始化外部类实例，但却初始化了Holder的实例)，
        // 而如果外部类是比较大的类时，该方法比较有意义，使用较小的Holder类实例，置换较大的外部类实例
        static Singleton4 obj = new Singleton4() ;
    }

    public static final Singleton4 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = Singleton4Holder.obj ;
        }
        return INSTANCE ;
    }

}
