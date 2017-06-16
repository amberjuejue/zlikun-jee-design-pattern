package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/16 12:07
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println(tab() + name);
    }
}
