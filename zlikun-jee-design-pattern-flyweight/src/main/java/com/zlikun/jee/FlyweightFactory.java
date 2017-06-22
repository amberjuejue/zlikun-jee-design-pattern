package com.zlikun.jee;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 10:26
 */
public class FlyweightFactory {

    private static final FlyweightFactory factory = new FlyweightFactory() ;

    private FlyweightFactory() {
    }

    public static final FlyweightFactory getInstance() {
        return factory ;
    }

    // 缓存多个Flyweight实例
    private Map<String ,Flyweight> storage = new HashMap<>() ;
    // 设置一个计数器，查看享元对象被使用次数
    private Map<String ,AtomicInteger> counter = new HashMap<>() ;

    /**
     * 获取Flyweight实例
     * @param state
     * @return
     */
    public Flyweight getFlyweight(String state) {
        Flyweight flyweight = this.storage.get(state) ;
        if (flyweight == null) {
            flyweight = new AuthorizationFlyweight(state) ;
            storage.put(state ,flyweight) ;
        }

        int times = 1 ;
        AtomicInteger ai = counter.get(state) ;
        if (ai == null) {
            ai = new AtomicInteger(times) ;
            counter.put(state ,ai) ;
        } else {
            times = ai.incrementAndGet() ;
        }

        System.out.println(String.format("状态[%s]被共享 %d 次" ,state ,times));

        return flyweight ;
    }

}
