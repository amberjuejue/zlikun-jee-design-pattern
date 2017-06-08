package com.zlikun.jee.product.factory;

import com.zlikun.jee.product.CPU;
import com.zlikun.jee.product.MainBoard;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 12:01
 */
public interface PCFactory {

    CPU createCPU() ;

    MainBoard createMainBoard() ;

}
