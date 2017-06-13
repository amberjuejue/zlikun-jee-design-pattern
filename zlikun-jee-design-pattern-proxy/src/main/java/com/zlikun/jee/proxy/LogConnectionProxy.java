package com.zlikun.jee.proxy;

import com.zlikun.jee.Connection;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/13 9:31
 */
public class LogConnectionProxy implements Connection {

    private Connection connection ;

    public LogConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute(String sql) {

        System.out.println("开始执行数据库操作 ...");

        this.connection.execute(sql);

        System.out.println("完成执行数据库操作 ...");

    }
}
