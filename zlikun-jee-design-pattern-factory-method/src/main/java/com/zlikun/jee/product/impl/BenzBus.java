package com.zlikun.jee.product.impl;

import com.zlikun.jee.product.Brand;
import com.zlikun.jee.product.Bus;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 10:33
 */
public class BenzBus implements Bus {
    @Override
    public String brand() {
        return Brand.BENZ.getChineseName();
    }

    @Override
    public int capacity() {
        return 60;
    }
}
