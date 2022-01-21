/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.telegrambot.commands;

/**
 *
 * @author fcastillo
 */
public interface Command {

  public void sendMessage(String chatId);
  
}
