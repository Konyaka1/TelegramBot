package com.telegram.bot.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ControlConstants {
    public static final String START_MSG = "/start";

    public static final String HELP_MSG = "/help";

    public static final String START_TEXT = "Hello, enter city name and you will get some nice info!\nsend me /help if you have problems";

    public static final String HELP_TEXT = "lol, r u kidding me?\n/help - lol\n/start - lolx2\n/all - get all provided cities";

    public static final String DEFAULT_TEXT = "There are only:\n/start; /help; /all";

    public static final String ILLEGAL_TEXT = "Pls, send text msg";

    public static final String ALL_MSG = "/all";
}
