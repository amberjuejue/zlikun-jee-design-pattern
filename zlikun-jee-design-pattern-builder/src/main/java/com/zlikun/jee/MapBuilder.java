package com.zlikun.jee;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个工具类，便于创建一个Map实例，Map无法指定泛型，所以直接使用Object，后面自己转型
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/9 11:29
 */
public class MapBuilder {

    private Map<Object ,Object> map ;

    public MapBuilder(int capacity) {
        this.map = new HashMap<>(capacity) ;
    }

    public static final MapBuilder init() {
        return new MapBuilder(1 << 4) ;
    }

    public static final MapBuilder init(int capacity) {
        return new MapBuilder(capacity) ;
    }

    public MapBuilder put(Object key ,Object value) {
        this.map.put(key ,value) ;
        return this ;
    }

    public Map<Object ,Object> build() {
        return this.map ;
    }

}
