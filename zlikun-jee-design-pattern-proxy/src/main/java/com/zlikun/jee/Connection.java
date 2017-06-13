package com.zlikun.jee;

/**
 * 模拟数据库连接接口
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/13 9:23
 */
public interface Connection {

    /**
     * 执行SQL语句
     * @param sql
     */
    void execute(String sql) ;

}
