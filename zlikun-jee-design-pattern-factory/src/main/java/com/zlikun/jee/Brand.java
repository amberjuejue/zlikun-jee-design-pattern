package com.zlikun.jee;

/**
 * 汽车品牌
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 8:52
 */
public enum Brand {

    FERRARI("法拉利") ,
    LAMBORGHINI("兰博基尼") ,
    ;

    private String chineseName ;

    private Brand(String chineseName) {
        this.chineseName = chineseName ;
    }

    public String getChineseName() {
        return chineseName;
    }
}
