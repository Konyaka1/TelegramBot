package com.telegram.bot.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageHandlerFactory {

    @Autowired
    private MessageHandler standardMessageHandler;

    @Autowired
    private MessageHandler controlMessageHandler;

    @Autowired
    private MessageHandler illegalMessageHandler;

    public MessageHandler getMessageHandler(String message) {
        if (message == null || message.isBlank()){
            return illegalMessageHandler;
        }
        if (message.startsWith("/")) {
            return controlMessageHandler;
        }
        return standardMessageHandler;
    }
}
