package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/16 11:55
 */
public abstract class Component {

    protected String name ;
    protected int level ;       // 该参数与本例无关，仅用于美化输出

    public Component(String name) {
        this.name = name;
    }

    public void add(Component c) {
        throw new UnsupportedOperationException() ;
    }

    public void remove(Component c) {
        throw new UnsupportedOperationException() ;
    }

    public void print() {
        throw new UnsupportedOperationException() ;
    }

    /**
     * 根据所属层级，计算制表符前缀，仅用于美化输出结果
     * @return
     */
    protected String tab() {
        StringBuilder sb = new StringBuilder() ;
        for (int i = 0; i < this.level; i++) {
            sb.append("\t") ;
        }
        return sb.toString() ;
    }

}
