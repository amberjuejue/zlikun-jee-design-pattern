package com.zlikun.jee.factory;

import com.zlikun.jee.product.Brand;
import com.zlikun.jee.product.Bus;
import com.zlikun.jee.product.impl.BenzBus;
import com.zlikun.jee.product.impl.FerrariBus;

/**
 * 巴士工厂(负责巴士产品线)
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 8:58
 */
public class BusFactory implements ProductFactory<Bus> {

    private Brand brand ;

    public BusFactory(Brand brand) {
        if (brand == null)
            throw new IllegalArgumentException("brand is required!") ;
        this.brand = brand;
    }

    @Override
    public Bus create() {
        switch (brand) {
            case FERRARI: return new FerrariBus() ;
            case BENZ:return new BenzBus() ;
            default: throw new IllegalArgumentException("不支持的巴士品牌") ;
        }
    }
}
