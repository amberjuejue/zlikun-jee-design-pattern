package com.zlikun.jee;

/**
 * 模拟MySQL或其它数据库的连接实现
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/13 9:26
 */
public class ConnectionImpl implements Connection {
    @Override
    public void execute(String sql) {
        System.out.println("执行SQL：" + sql);
    }
}
