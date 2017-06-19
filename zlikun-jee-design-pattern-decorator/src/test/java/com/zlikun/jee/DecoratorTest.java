package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/19 11:07
 */
public class DecoratorTest {

    @Test
    public void test() {

        String user = "zlikun" ;
        int seniority = 7 ;

        // 原始奖金
        Component component = new ComponetImpl() ;
        Assert.assertEquals(0 ,component.calc(user ,seniority) ,0);

        // 月度奖金
        Decorator d1 = new MonthDecorator(component) ;
        Assert.assertEquals(1000 ,d1.calc(user ,seniority) ,0);

        // 年度奖金
        Decorator d2 = new YearDecorator(d1) ;
        Assert.assertEquals(3000 ,d2.calc(user ,seniority) ,0);

        // 层层包装，感觉跟代理模式很像 ~

    }

}
