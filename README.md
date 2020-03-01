# TelegramBot

Installing

Clone or download this project.
What you need to run:
1. JDK 8 or greater.
2. Maven 3.6.2.
3. PostgresSQL 12.
4. In src/main/resources/application.properties enter your password from PostgresSQL in spring.datasource.password=.
5. Run this file src/main/java/db/newdb.sql in PostgresSQL.
6. Open cmd in repository root folder and write "mvn spring-boot:run".
7. After starting, open localhost:8080 in your browser.
8. You'll see login page. Enter TelegramBot name and token (you can find this in src/main/resources/application.properties).
9. Add city and information, try this bot in telegram @MicantiaBot
