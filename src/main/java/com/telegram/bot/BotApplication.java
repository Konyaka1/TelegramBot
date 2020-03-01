package com.telegram.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(BotApplication.class, args);
	}

}
