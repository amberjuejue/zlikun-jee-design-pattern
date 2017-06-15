package com.zlikun.jee.log.impl;

import com.zlikun.jee.log.LoggerV1;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/15 10:55
 */
public class ConsoleLoggerV1Impl implements LoggerV1 {

    @Override
    public void log(String message) {
        if (message == null)
            throw new IllegalArgumentException("message is required .") ;
        System.out.println("控制台输出日志 : " + message);
    }

}
