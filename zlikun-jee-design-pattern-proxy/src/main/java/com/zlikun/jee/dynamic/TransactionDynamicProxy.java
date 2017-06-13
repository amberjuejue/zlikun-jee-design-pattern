package com.zlikun.jee.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/13 10:38
 */
public class TransactionDynamicProxy implements InvocationHandler {


    private Object obj ;

    public TransactionDynamicProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * 前置处理逻辑
     */
    private void before() {
        System.out.println("开启事务 ...");
    }

    /**
     * 后置处理逻辑
     */
    private void after() {
        System.out.println("提交事务 ...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object value = method.invoke(this.obj ,args) ;
        after();

        return value;
    }
}
