/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Message;

/**
 *
 * @author fcastillo
 */
public interface Command {

  public void sendMessage(Message message);
  
}
