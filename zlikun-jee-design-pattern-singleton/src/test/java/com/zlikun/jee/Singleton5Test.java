package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:23
 */
public class Singleton5Test {

    @Test
    public void test_single() {

        Assert.assertTrue(Singleton5.getInstance() == Singleton5.getInstance());

    }

    @Test
    public void test_multi() {

        final Set<Singleton5> set = new HashSet<>() ;
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
                            set.add(Singleton5.getInstance()) ;
                            break;
                        }
                    }
                }
            });
        }

        exec.shutdown();
        while (!exec.isTerminated()) ;

        // 如果元素个数为1，表示未生成不同实例
        Assert.assertEquals(1 ,set.size());
    }

}
