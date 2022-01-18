package com.fcastillo.telegrambot;

import java.util.ResourceBundle;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author fcastillo
 */
public class Bot extends TelegramLongPollingBot {

  @Override
  public String getBotToken() {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    String token = resourceBundle.getString("token");
    return token;
  }

  @Override
  public void onUpdateReceived(Update update) {

    Runnable runnable = () -> {

      if (update.hasMessage()) {
        Message message = update.getMessage();
        if (message.hasText()) {
          String text = message.getText();
          if (text.equalsIgnoreCase("/start")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Hello world");
            sendMessage.setParseMode(ParseMode.MARKDOWN);
            sendMessage.setChatId(message.getChatId().toString());
            try {
              execute(sendMessage);
            } catch (TelegramApiException e) {
              System.out.println("Excepcion: " + e.getLocalizedMessage());
            }
          }
        }
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();

  }

  @Override
  public String getBotUsername() {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    String botname = resourceBundle.getString("botname");
    return botname;
  }

}
