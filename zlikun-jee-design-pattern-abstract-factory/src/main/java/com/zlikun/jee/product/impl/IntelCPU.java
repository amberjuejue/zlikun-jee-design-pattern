package com.zlikun.jee.product.impl;

import com.zlikun.jee.product.CPU;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 11:04
 */
public class IntelCPU implements CPU {
    @Override
    public int pins() {
        return 100;
    }

    @Override
    public String model() {
        return "Intel";
    }
}
