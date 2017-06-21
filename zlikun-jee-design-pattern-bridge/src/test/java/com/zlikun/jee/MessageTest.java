package com.zlikun.jee;

import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/21 17:26
 */
public class MessageTest {

    /**
     * 实现了消息本身与发送消息服务之间的解耦，消息本身与发送服务各自演化
     * AbstractMessage 对象持有 MessageImplementor 实例，实现了桥接
     */
    @Test
    public void test() {

        // 创建一个实现对象，短信发送服务
        MessageImplementor impl = new MessageSMS() ;

        // 创建一个消息对象，普通消息
        AbstractMessage msg = new CommonMessage(impl) ;

        // 发送消息
        msg.sendMessage("小二，上菜!" ,"zlikun");

        // 创建一个加急消息
        msg = new UrgencyMessage(impl) ;

        msg.sendMessage("老板，结帐!" ,"zlikun");

        // 创建一个特急消息
        msg = new SpecialUrgencyMessage(new MessageEmail()) ;

        msg.sendMessage("这是500万的支票，随便花!" ,"zlikun");

    }

}
