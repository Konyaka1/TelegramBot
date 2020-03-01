package com.telegram.bot.handlers.impl;

import com.telegram.bot.handlers.MessageHandler;
import com.telegram.bot.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StandardMessageHandler implements MessageHandler {

    @Autowired
    private ICityService cityService;

    @Override
    public SendMessage handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        String msg = update.getMessage().getText();
        msg = msg.substring(0, 1).toUpperCase() + msg.substring(1);
        sendMessage.setText(cityService.getByCityName(msg));
        return sendMessage;
    }
}
