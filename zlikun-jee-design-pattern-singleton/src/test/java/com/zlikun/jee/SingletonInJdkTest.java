package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * JDK中的单例模式应用
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/5 18:01
 */
public class SingletonInJdkTest {

    /**
     * JDK 使用单例模式的几个常用类
     *      java.lang.Runtime#getRuntime()
     */
    @Test
    public void test() {

        // 饿汉式，即：一开始就实例化，获取实例方法直接返回该实例即可
        Assert.assertEquals(Runtime.getRuntime() ,Runtime.getRuntime());
        Assert.assertTrue(Runtime.getRuntime() == Runtime.getRuntime());

        // 懒汉式，即：调用获取实例方法时，才实例化单例类，需注意线程安全(双重检查锁)
        // java.awt 包下单例类较多(通常用于实现默认值)
        Assert.assertTrue(Toolkit.getDefaultToolkit() == Toolkit.getDefaultToolkit());
        Assert.assertTrue(Desktop.getDesktop() == Desktop.getDesktop());

    }

}
