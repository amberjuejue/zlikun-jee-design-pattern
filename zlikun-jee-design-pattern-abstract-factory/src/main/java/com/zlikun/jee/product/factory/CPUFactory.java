package com.zlikun.jee.product.factory;

import com.zlikun.jee.product.CPU;
import com.zlikun.jee.product.impl.AMDCPU;
import com.zlikun.jee.product.impl.IntelCPU;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 12:02
 */
public class CPUFactory {

    public static final CPU create(int pins) {
        if (pins == 100) {
            return new IntelCPU() ;
        }
        if (pins == 120) {
            return new AMDCPU() ;
        }
        throw new IllegalArgumentException("没有针脚为 " + pins + " 的CPU") ;
    }

}
