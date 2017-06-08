package com.zlikun.jee.product.impl;

import com.zlikun.jee.product.CPU;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 11:05
 */
public class AMDCPU implements CPU {
    @Override
    public int pins() {
        return 120;
    }

    @Override
    public String model() {
        return "AMD";
    }
}
