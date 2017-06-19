package com.zlikun.jee;

import java.util.Date;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/19 10:55
 */
public class ComponetImpl implements Component {
    @Override
    public double calc(String user ,int seniority) {
        // 默认实现，没有奖金
        return 0;
    }
}
