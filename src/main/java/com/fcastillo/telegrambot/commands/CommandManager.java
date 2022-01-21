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
public class CommandManager {

  public static Command create(String commandType) throws Exception {
    switch (commandType) {
     
      case "/comenzar":
        return new Beginning();
      
      case "/finalizar":
        return new Finish();
      
      default:
        throw new Exception("No se reconoce tipo de comando");
    }
  }

}
