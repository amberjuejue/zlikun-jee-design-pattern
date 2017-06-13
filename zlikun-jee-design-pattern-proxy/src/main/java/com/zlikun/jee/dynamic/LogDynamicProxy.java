package com.zlikun.jee.dynamic;

import com.zlikun.jee.Connection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/13 9:39
 */
public class LogDynamicProxy implements InvocationHandler {

    private Object obj ;

    public LogDynamicProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * 前置处理逻辑
     */
    private void before() {
        System.out.println("开始执行数据库操作 ...");
    }

    /**
     * 后置处理逻辑
     */
    private void after() {
        System.out.println("完成执行数据库操作 ...");
    }

    /**
     *
     * @param proxy     代理对象的引用，类似this的作用，当前类中this指向InvocationHandler实例，而proxy则指向代理类实例
     * @param method    代理方法
     * @param args      代理方法参数
     * @return          被代理类方法执行返回结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 代理类：com.sun.proxy.$Proxy4
        System.out.println("代理类：" + proxy.getClass().getName());

        before();
        Object value = method.invoke(this.obj ,args) ;
        after();

        return value;
    }
}
