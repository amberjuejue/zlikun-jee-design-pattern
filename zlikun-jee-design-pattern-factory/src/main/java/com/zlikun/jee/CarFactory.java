package com.zlikun.jee;

import com.zlikun.jee.impl.FerrariCar;
import com.zlikun.jee.impl.LamborghiniCar;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 8:58
 */
public class CarFactory {

    public static final Car create(Brand brand) {
        if (brand == null)
            throw new IllegalArgumentException("brand is required!") ;
        switch (brand) {
            case FERRARI: return new FerrariCar() ;
            case LAMBORGHINI:return new LamborghiniCar() ;
            default: throw new IllegalArgumentException("不支持的汽车品牌") ;
        }
    }

}
