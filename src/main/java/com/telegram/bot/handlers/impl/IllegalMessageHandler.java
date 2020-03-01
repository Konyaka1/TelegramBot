package com.telegram.bot.handlers.impl;

import com.telegram.bot.handlers.MessageHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import static com.telegram.bot.utils.ControlConstants.ILLEGAL_TEXT;

@Component
public class IllegalMessageHandler implements MessageHandler {
    @Override
    public SendMessage handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(ILLEGAL_TEXT);
        return sendMessage;
    }
}
