package com.zlikun.jee;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/16 11:58
 */
public class Composite extends Component {

    public Composite(String name) {
        super(name);
    }

    private List<Component> children ;

    @Override
    public void add(Component c) {
        if (children == null)
            children = new ArrayList<>() ;
        c.level = this.level + 1 ;  // 计算节点层级
        children.add(c) ;
    }

    @Override
    public void remove(Component c) {
        if (children == null || children.isEmpty())
            return ;
        children.remove(c) ;
    }

    @Override
    public void print() {
        System.out.println(tab() + name);
        if(children != null && !children.isEmpty()) {
            for (Component c : children) {
                c.print();
            }
        }
    }
}
