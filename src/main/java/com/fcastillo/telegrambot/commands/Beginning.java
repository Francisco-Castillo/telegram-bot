/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.telegrambot.commands;

import com.fcastillo.telegrambot.Bot;
import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author fcastillo
 */
public class Beginning implements Command {

  @Override
  public void sendMessage(String chatId) {
    try {
      Bot bot = new Bot();

      SendMessage sendMessage = new SendMessage();

      sendMessage.setText("¡Comencemos!");
      sendMessage.setParseMode(ParseMode.MARKDOWN);
      sendMessage.setChatId(chatId);

      ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
      List<KeyboardRow> keyboard = new ArrayList<>();

      KeyboardRow row = new KeyboardRow();
      row.add("Boton 1");
      row.add("Boton 2");

      keyboard.add(row);

      row = new KeyboardRow();
      row.add("Boton 3");
      row.add("Boton 4");

      keyboard.add(row);

      keyBoardMarkup.setKeyboard(keyboard);

      sendMessage.setReplyMarkup(keyBoardMarkup);

      bot.execute(sendMessage);
    } catch (TelegramApiException e) {
      System.out.println("Excepcion: " + e.getLocalizedMessage());
    }

  }

}
