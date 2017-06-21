package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/21 17:20
 */
public abstract class AbstractMessage {

    protected MessageImplementor impl ;

    public AbstractMessage(MessageImplementor impl) {
        this.impl = impl;
    }

    /**
     * 发送消息，调用实现类的发送方法
     * @param message
     * @param toUser
     */
    public void sendMessage(String message ,String toUser) {
        this.impl.send(message ,toUser);
    }

}
