package com.telegram.bot.handlers.impl;

import com.telegram.bot.handlers.MessageHandler;
import com.telegram.bot.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.telegram.bot.utils.ControlConstants;

import java.util.List;

@Component
public class ControlMessageHandler implements MessageHandler {

    @Autowired
    private ICityService cityService;

    @Override
    public SendMessage handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        switch (update.getMessage().getText()){
            case ControlConstants.START_MSG:
                sendMessage.setText(ControlConstants.START_TEXT);
                break;
            case ControlConstants.HELP_MSG:
                sendMessage.setText(ControlConstants.HELP_TEXT);
                break;
            case ControlConstants.ALL_MSG:
                sendMessage.setText(toMsg(cityService.getAllNames()));
                break;
            default:
                sendMessage.setText(ControlConstants.DEFAULT_TEXT);
                break;
        }
        return sendMessage;
    }

    private String toMsg(List<String> allNames){
        StringBuilder stringBuilder = new StringBuilder("There are:");
        for (String it : allNames){
            stringBuilder.append("\n").append(it);
        }
        return stringBuilder.toString();
    }
}
