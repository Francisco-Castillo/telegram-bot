package com.fcastillo.telegrambot;

import com.fcastillo.telegrambot.commands.CommandManager;
import com.fcastillo.telegrambot.commands.Command;
import java.util.ResourceBundle;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
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

    if (update.hasMessage() && update.getMessage().hasText()) {
      try {
        Message message = update.getMessage();
        Command command = CommandManager.create(message.getText());
        command.sendMessage(message.getChatId().toString());
      } catch (Exception e) {
        System.out.println("Ocurrio un error: " + e.getLocalizedMessage());
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
