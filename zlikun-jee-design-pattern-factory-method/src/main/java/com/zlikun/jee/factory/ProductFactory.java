package com.zlikun.jee.factory;


import com.zlikun.jee.product.Vehicle;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 10:13
 */
public interface ProductFactory<T extends Vehicle> {

    T create() ;

}
