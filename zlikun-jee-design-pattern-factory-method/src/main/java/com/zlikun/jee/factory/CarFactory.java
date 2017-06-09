package com.zlikun.jee.factory;

import com.zlikun.jee.product.Brand;
import com.zlikun.jee.product.Car;
import com.zlikun.jee.product.impl.FerrariCar;
import com.zlikun.jee.product.impl.LamborghiniCar;

/**
 * 汽车工厂(负责汽车产品线)
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 8:58
 */
public class CarFactory implements ProductFactory<Car> {

    private Brand brand ;

    public CarFactory(Brand brand) {
        if (brand == null)
            throw new IllegalArgumentException("brand is required!") ;
        this.brand = brand;
    }

    @Override
    public Car create() {
        switch (brand) {
            case FERRARI: return new FerrariCar() ;
            case LAMBORGHINI:return new LamborghiniCar() ;
            default: throw new IllegalArgumentException("不支持的汽车品牌") ;
        }
    }
}
