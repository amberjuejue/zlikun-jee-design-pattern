package com.zlikun.jee;

import com.zlikun.jee.proxy.LogConnectionProxy;
import com.zlikun.jee.proxy.TransactionConnectionProxy;
import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/13 9:28
 */
public class ConnectionTest {

    private String sql = "SELECT '1'" ;

    @Test
    public void no_proxy() {

        Connection conn = new ConnectionImpl() ;

        /**
         * 执行SQL：SELECT '1'
         */
        conn.execute(sql);

    }

    @Test
    public void proxy() {

        // 使用日志代理、事务代理
        Connection conn = new LogConnectionProxy(new TransactionConnectionProxy(new ConnectionImpl()));

        /**
         * 开始执行数据库操作 ...
         * 开启事务 ...
         * 执行SQL：SELECT '1'
         * 提交事务 ...
         * 完成执行数据库操作 ...
         */
        conn.execute(sql);

    }

}
