package com.zlikun.jee.proxy;

import com.zlikun.jee.Connection;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/13 9:30
 */
public class TransactionConnectionProxy implements Connection {

    private Connection connection ;

    public TransactionConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute(String sql) {

        System.out.println("开启事务 ...");

        this.connection.execute(sql);

        System.out.println("提交事务 ...");

    }
}
