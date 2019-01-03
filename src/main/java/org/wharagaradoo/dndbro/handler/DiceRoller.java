package org.wharagaradoo.dndbro.handler;

import org.wharagaradoo.dndbro.exception.DiceNotFoundException;
import org.wharagaradoo.dndbro.util.Dice;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-28. */
public class DiceRoller {

  public static String processMessage(String msg) {
    String[] strings = parseMessage(msg);
    if (strings.length != 2) {

      return "Please specify a dice";
    }
    try {
      return new Dice(strings[1]).roll().getOutput();
    } catch (DiceNotFoundException e) {

      return e.getMessage();
    }
  }

  private static String[] parseMessage(String message) {

    return message.split(" ");
  }
}
