package com.zlikun.jee.product.impl;

import com.zlikun.jee.product.MainBoard;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 11:05
 */
public class GAMainBoard extends MainBoard {

    public GAMainBoard() {
        super(100);
    }

    @Override
    public String model() {
        return "技嘉主板";
    }
}
