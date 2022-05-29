/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.telegrambot.commands;

import com.fcastillo.telegrambot.Bot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author fcastillo
 */
public class Finish implements Command {

  @Override
  public void sendMessage(Message message) {
    try {
      Bot bot = new Bot();
      
      SendMessage sendMessage = new SendMessage();
      
      sendMessage.setText("¡Gracias por utilizarme, hasta la próxima!");
      sendMessage.setParseMode(ParseMode.MARKDOWN);
      sendMessage.setChatId(message.getChatId().toString());
      
      ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove(Boolean.TRUE);
      
      sendMessage.setReplyMarkup(keyboardMarkup);
      
      bot.execute(sendMessage);
    } catch (TelegramApiException e) {
      System.out.println("Excepcion: " + e.getLocalizedMessage());
    }
  }
}
