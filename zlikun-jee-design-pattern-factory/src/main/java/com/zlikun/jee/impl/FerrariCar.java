package com.zlikun.jee.impl;

import com.zlikun.jee.Brand;
import com.zlikun.jee.Car;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 8:56
 */
public class FerrariCar implements Car {
    @Override
    public String brand() {
        return Brand.FERRARI.getChineseName();
    }
}
