package com.zlikun.jee.product;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 11:01
 */
public interface CPU {

    /**
     * 针脚数
     * @return
     */
    int pins() ;

    /**
     * CPU型号
     * @return
     */
    String model() ;
}
