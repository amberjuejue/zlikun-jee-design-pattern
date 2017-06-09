package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

/**
 * JDK中的建造者模式案例
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/9 9:22
 */
public class BuilderInJdkTest {

    @Test
    public void test() {

        // 非线程安全
        StringBuilder builder = new StringBuilder() ;
        builder.append("Hello ").append("!") ;
        Assert.assertEquals("Hello !" ,builder.toString());

        // 线程安全(方法都被synchronized关键字修饰)
        StringBuffer buffer = new StringBuffer() ;
        buffer.append("Hello ").append("!") ;
        Assert.assertEquals("Hello !" ,buffer.toString());

        // 另外OkHttp3库中大量使用了建造者模式

    }

}
