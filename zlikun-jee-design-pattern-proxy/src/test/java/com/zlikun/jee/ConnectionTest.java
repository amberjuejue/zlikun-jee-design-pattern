package com.zlikun.jee;

import com.zlikun.jee.dynamic.LogDynamicProxy;
import com.zlikun.jee.dynamic.TransactionDynamicProxy;
import com.zlikun.jee.proxy.LogConnectionProxy;
import com.zlikun.jee.proxy.TransactionConnectionProxy;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/13 9:28
 */
public class ConnectionTest {

    private String sql = "SELECT '1'" ;

    /**
     * 无代理
     */
    @Test
    public void no_proxy() {

        Connection conn = new ConnectionImpl() ;

        /**
         * 执行SQL：SELECT '1'
         */
        conn.execute(sql);

    }

    /**
     * 代理
     */
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

    /**
     * 动态代理
     */
    @Test
    public void dynamic_proxy() {

        // 被代理对象
        Connection conn = new ConnectionImpl() ;
        // Object newProxyInstance(ClassLoader loader ,Class<?>[] interfaces ,InvocationHandler h)
        // 获取代理对象，ClassLoader应与被代理对象使用相同ClassLoader、被代理对象接口、InvocationHandler(实际代理处理对象)
        // 返回代理对象，需要强制转换
        Connection logDynamicProxy = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader()
                ,conn.getClass().getInterfaces()
                ,new LogDynamicProxy(conn));

        // 事务动态代理
        Connection transactionDynamicProxy = (Connection) Proxy.newProxyInstance(logDynamicProxy.getClass().getClassLoader()
                ,logDynamicProxy.getClass().getInterfaces()
                ,new TransactionDynamicProxy(logDynamicProxy));

        /**
         * 开启事务 ...
         * 开始执行数据库操作 ...
         * 执行SQL：SELECT '1'
         * 完成执行数据库操作 ...
         * 提交事务 ...
         */
        transactionDynamicProxy.execute(sql);

        Assert.assertTrue(logDynamicProxy instanceof Proxy);
        Assert.assertTrue(transactionDynamicProxy instanceof Proxy);
    }

}
