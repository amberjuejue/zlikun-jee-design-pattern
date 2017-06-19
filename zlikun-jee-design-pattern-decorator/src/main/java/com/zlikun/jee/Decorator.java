package com.zlikun.jee;

import java.util.Date;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/19 10:56
 */
public class Decorator implements Component {

    private Component component ;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public double calc(String user ,int seniority) {
        return this.component.calc(user ,seniority);
    }
}
