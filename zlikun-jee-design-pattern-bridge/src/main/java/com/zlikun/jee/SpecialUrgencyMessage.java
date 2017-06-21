package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/21 17:25
 */
public class SpecialUrgencyMessage extends AbstractMessage {
    public SpecialUrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "特急：" + message ;
        super.sendMessage(message, toUser);
    }
}
