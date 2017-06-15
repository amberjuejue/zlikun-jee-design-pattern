package com.zlikun.jee;

import com.zlikun.jee.log.LoggerV1;
import com.zlikun.jee.log.LoggerV2;
import com.zlikun.jee.log.impl.ConsoleLoggerV1Impl;
import com.zlikun.jee.log.impl.LoggerV2Adapter;
import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/15 10:56
 */
public class LoggerTest {

    @Test
    public void test() {

        LoggerV1 loggerV1 = new ConsoleLoggerV1Impl() ;

        // 控制台输出日志 : 张三今年18岁
        loggerV1.log("张三今年18岁");

        // 现在发现日志API不好用，比如消息需要手动拼接，现升级日志API，但希望可以复用原日志实现
        LoggerV2 loggerV2 = new LoggerV2Adapter(new ConsoleLoggerV1Impl()) ;

        // 控制台输出日志 : 李四今年21岁
        loggerV2.log("{}今年{}岁" ,"李四" ,21);

    }

}
