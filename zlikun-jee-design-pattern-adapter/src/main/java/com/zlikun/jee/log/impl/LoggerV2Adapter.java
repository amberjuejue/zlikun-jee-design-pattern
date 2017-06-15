package com.zlikun.jee.log.impl;

import com.zlikun.jee.log.LoggerV1;
import com.zlikun.jee.log.LoggerV2;

/**
 * 第二版日志API的适配器类，用于适配第一版的日志实现
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/15 10:59
 */
public class LoggerV2Adapter implements LoggerV2 {

    private LoggerV1 loggerV1 ;

    public LoggerV2Adapter(LoggerV1 loggerV1) {
        this.loggerV1 = loggerV1;
    }

    @Override
    public void log(String message, Object... args) {
        if (message == null)
            throw new IllegalArgumentException("message is required .") ;
        // 组装消息
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                message = message.replaceFirst("\\{\\}" ,arg != null ? arg.toString() : "null") ;
            }
        }
        // 输出消息
        this.loggerV1.log(message);
    }
}
