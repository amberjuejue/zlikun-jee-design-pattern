package com.zlikun.jee.product.impl;

import com.zlikun.jee.product.MainBoard;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 12:00
 */
public class MSIMainBoard extends MainBoard {
    public MSIMainBoard() {
        super(120);
    }

    @Override
    public String model() {
        return "微星主板";
    }
}
