package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/9 11:33
 */
public class MapBuilderTest {

    @Test
    public void test() {

        Map<Object ,Object> map = MapBuilder.init(4)
                .put("name" ,"zlikun")
                .put("age" ,120)
                .build() ;

        Assert.assertEquals("zlikun" ,map.get("name"));

    }

}
