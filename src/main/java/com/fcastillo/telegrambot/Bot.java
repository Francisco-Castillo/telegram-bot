package com.fcastillo.telegrambot;

import java.util.ResourceBundle;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

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
          } catch (Exception e) {
            System.out.println("Excepcion: " + e.getLocalizedMessage());
          }
        }
      }

    }
  }

  @Override
  public String getBotUsername() {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    String botname = resourceBundle.getString("botname");
    return botname;
  }

}
