package com.zlikun.jee.product.impl;


import com.zlikun.jee.product.Brand;
import com.zlikun.jee.product.Bus;
import com.zlikun.jee.product.Car;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 8:56
 */
public class FerrariBus implements Bus {
    @Override
    public String brand() {
        return Brand.FERRARI.getChineseName();
    }

    @Override
    public int capacity() {
        return 120;
    }
}
