package com.zlikun.jee.product.factory;

import com.zlikun.jee.product.CPU;
import com.zlikun.jee.product.MainBoard;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 12:02
 */
public class AMDPCFactory implements PCFactory {

    private int pins = 120 ;

    @Override
    public CPU createCPU() {
        return CPUFactory.create(pins);
    }

    @Override
    public MainBoard createMainBoard() {
        return MainBoardFactory.create(pins);
    }
}
