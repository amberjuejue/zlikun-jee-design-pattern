package com.zlikun.jee.product.factory;

import com.zlikun.jee.product.MainBoard;
import com.zlikun.jee.product.impl.AMDCPU;
import com.zlikun.jee.product.impl.GAMainBoard;
import com.zlikun.jee.product.impl.IntelCPU;
import com.zlikun.jee.product.impl.MSIMainBoard;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 12:04
 */
public class MainBoardFactory {

    public static final MainBoard create(int holes) {
        if (holes == 100) {
            return new GAMainBoard() ;
        }
        if (holes == 120) {
            return new MSIMainBoard() ;
        }
        throw new IllegalArgumentException("没有CPU插槽针孔为 " + holes + " 的主板") ;
    }

}
