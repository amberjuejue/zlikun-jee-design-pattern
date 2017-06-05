package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:23
 */
public class Singleton4Test {

    @Test
    public void test_single() {

        Assert.assertTrue(Singleton4.getInstance() == Singleton4.getInstance());

    }

    @Test
    public void test_multi() {

        // 使用ConcurrentHashMap代替HashSet(内部使用HashMap，不适用于并发)，以应用于并发条件下
        final ConcurrentMap<Singleton4 ,Boolean> map = new ConcurrentHashMap<>() ;
        ExecutorService exec = Executors.newFixedThreadPool(400) ;

        // 约定一个执行时间(模拟并发，原因是类比较简单，初始化速度太快，无法真实再现并发情况)
        final long moment = System.currentTimeMillis() + 1000 ;
        for (int i = 0; i < 1000; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        // 到约定时间后再执行(构成并发)
                        if (moment < System.currentTimeMillis()) {
                            map.put(Singleton4.getInstance() ,Boolean.TRUE) ;
                            break;
                        }
                    }
                }
            });
        }

        exec.shutdown();
        while (!exec.isTerminated()) ;

        // 如果元素个数为1，表示未生成不同实例
        Assert.assertEquals(1 ,map.size());
    }

}
