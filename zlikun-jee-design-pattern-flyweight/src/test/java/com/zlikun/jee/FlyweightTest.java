package com.zlikun.jee;

import org.junit.Assert;
import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 10:52
 */
public class FlyweightTest {

    /**
     * 享元模式：本例中，AuthorizationFlyweight 为享元对象，在 FlyweightFactory 类中被缓存(共享)，通过 SecurityMgr 类中逻辑可以看出 AuthorizationFlyweight 实例是被共享的 <br>
     * 实例信息为 ["用户列表" ,"查看"] 的 AuthorizationFlyweight 被共享，即使多个用户，但只要拥有该权限则共享该实例
     */
    @Test
    public void test() {

        // 用户`艾希`执行登录
        SecurityMgr.getInstance().login("ashe"); ;

        // 用户`艾希`修改用户列表
        Assert.assertTrue(SecurityMgr.getInstance().hasPermit("ashe" ,"用户列表" ,"查看"));
        Assert.assertTrue(SecurityMgr.getInstance().hasPermit("ashe" ,"用户列表" ,"修改"));

        // 用户`金克丝`执行登录
        SecurityMgr.getInstance().login("jinx");

        // 用户`金克丝`查看用户列表
        Assert.assertTrue(SecurityMgr.getInstance().hasPermit("jinx" ,"用户列表" ,"查看"));
    }

}
