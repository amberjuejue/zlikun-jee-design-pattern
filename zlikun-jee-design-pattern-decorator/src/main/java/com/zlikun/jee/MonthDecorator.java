package com.zlikun.jee;

import java.util.Date;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/19 10:57
 */
public class MonthDecorator extends Decorator {

    public MonthDecorator(Component component) {
        super(component);
    }

    @Override
    public double calc(String user ,int seniority) {
        // 计算之前算出的奖金
        double origin = super.calc(user, seniority);

        // 按工龄，发放月奖金
        double prize = 0 ;
        if (seniority <= 3) {
            prize = seniority * 200 ;   // 工龄3年以及下，200 * 工龄
        } else {
            prize = 1000 ;              // 工龄大于3年，固定1000
        }

        return origin + prize ;
    }
}
