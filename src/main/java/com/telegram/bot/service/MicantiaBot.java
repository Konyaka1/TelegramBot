package com.telegram.bot.service;

import com.telegram.bot.handlers.MessageHandlerFactory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MicantiaBot extends TelegramLongPollingBot {


    @Getter
    @Value("${bot.micantia.username}")
    String botUsername;

    @Getter
    @Value("${bot.micantia.token}")
    String botToken;

    @Autowired
    private MessageHandlerFactory messageHandlerFactory;

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = messageHandlerFactory.getMessageHandler(update.getMessage().getText()).handle(update);
        try {
                execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        updates.forEach(this::onUpdateReceived);
    }
}
