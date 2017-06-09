package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/9 10:42
 */
public class TrainFactoryTest {

    @Test
    public void test() {

        // TrainFactory 封装了建造者建造顺序
        // TrainBuilder 细化、分步骤的构建产品
        TrainFactory factory = new TrainFactory(new TrainBuilder()) ;
        String train = factory.process() ;
        Assert.assertEquals("火车头-火车身-火车尾" ,train);

    }

}
