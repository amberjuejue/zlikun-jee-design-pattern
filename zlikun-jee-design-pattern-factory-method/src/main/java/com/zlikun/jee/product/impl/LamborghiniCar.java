package com.zlikun.jee.product.impl;


import com.zlikun.jee.product.Brand;
import com.zlikun.jee.product.Car;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 8:58
 */
public class LamborghiniCar implements Car {
    @Override
    public String brand() {
        return Brand.LAMBORGHINI.getChineseName();
    }

    @Override
    public int price() {
        return 160;
    }
}
