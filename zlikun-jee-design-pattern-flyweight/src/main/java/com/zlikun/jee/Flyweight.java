package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 10:21
 */
public interface Flyweight {

    /**
     * 判断传入安全实体和权限，是否各享元对象内部状态匹配
     * @param securityEntity    安全实体
     * @param permit            权限
     * @return                  true 表示匹配、false 表示不匹配
     */
    boolean match(String securityEntity ,String permit) ;

}
