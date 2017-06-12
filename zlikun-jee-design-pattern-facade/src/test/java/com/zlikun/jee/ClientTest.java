package com.zlikun.jee;

import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/12 11:01
 */
public class ClientTest {

    @Test
    public void test() {

        Facade f = new FacadeImpl() ;

        f.turnOn();
        f.turnOff();

    }

}
