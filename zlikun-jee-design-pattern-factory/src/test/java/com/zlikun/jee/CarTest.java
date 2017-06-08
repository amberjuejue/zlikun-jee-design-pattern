package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 9:01
 */
public class CarTest {

    /**
     * 测试简单工厂设计模式，该案例中，隐藏了具体品牌汽车实现类
     */
    @Test
    public void test() {

        Car car0 = CarFactory.create(Brand.FERRARI) ;
        Assert.assertEquals(Brand.FERRARI.getChineseName() ,car0.brand()) ;

        Car car2 = CarFactory.create(Brand.LAMBORGHINI) ;
        Assert.assertEquals(Brand.LAMBORGHINI.getChineseName() ,car2.brand());

    }

}
