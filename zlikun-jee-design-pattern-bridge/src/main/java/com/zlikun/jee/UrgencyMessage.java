package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/21 17:24
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急：" + message ;
        super.sendMessage(message, toUser);
    }
}
