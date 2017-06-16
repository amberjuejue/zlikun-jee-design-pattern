package com.zlikun.jee;

import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/16 11:57
 */
public class CompositeTest {

    @Test
    public void test() {

        Component root = new Composite("服装") ;

        Component c1 = new Composite("男装") ;
        Component c2 = new Composite("女装") ;

        // 由于level的计算方式原因，添加下级节点，必须在下级节点添加到当前节点前，否则计算level不准确
        root.add(c1);
        root.add(c2);

        Component leaf1 = new Leaf("衬衫") ;
        Component leaf2 = new Leaf("牛仔裤") ;
        Component leaf3 = new Leaf("打底裤") ;
        Component leaf4 = new Leaf("短裙") ;

        c1.add(leaf1);
        c1.add(leaf2);
        c2.add(leaf3);
        c2.add(leaf4);

        // 输出树形菜单结果
        root.print();

        // 移除部分节点
        c2.remove(leaf3);

        // 输出树形菜单结果
        root.print();

    }

}
