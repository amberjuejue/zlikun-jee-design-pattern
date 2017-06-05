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
public class Singleton0Test {

    @Test
    public void test_single() {

        Assert.assertTrue(Singleton0.getInstance() == Singleton0.getInstance());

    }

    @Test
    public void test_multi() {

        final Set<Singleton0> set = new HashSet<>() ;
        ExecutorService exec = Executors.newFixedThreadPool(50) ;

        for (int i = 0; i < 1000; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    set.add(Singleton0.getInstance()) ;
                }
            });
        }

        exec.shutdown();
        while (!exec.isTerminated()) ;

        // 如果元素个数为1，表示未生成不同实例
        Assert.assertEquals(1 ,set.size());
    }

}
