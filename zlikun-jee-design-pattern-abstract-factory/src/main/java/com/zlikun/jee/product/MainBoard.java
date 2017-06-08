package com.zlikun.jee.product;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 11:02
 */
public abstract class MainBoard {

    private int holes ;

    public MainBoard(int holes) {
        this.holes = holes;
    }

    /**
     * 主板CPU插槽针孔数
     * @return
     */
    public int holes() {
        return holes ;
    }

    /**
     * 主板型号
     * @return
     */
    public abstract String model() ;

}
