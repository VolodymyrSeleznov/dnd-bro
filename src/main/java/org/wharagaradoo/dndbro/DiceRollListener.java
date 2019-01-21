package org.wharagaradoo.dndbro;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.wharagaradoo.dndbro.exception.DiceNotFoundException;
import org.wharagaradoo.dndbro.util.Dice;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-28. */
public class DiceRollListener {

  private final MessageChannel channel;
  private final String msg;

  public DiceRollListener(MessageReceivedEvent event) {

    channel = event.getChannel();
    msg = event.getMessage().getContentDisplay();
  }

  private static String[] parseMessage(String message) {

    return message.split(" ");
  }

  public void process() {
    String[] strings = parseMessage(msg);
    String output;
    if (strings.length != 2) {

      output = "Please specify a dice";
    }
    try {

      output = new Dice(strings[1]).roll().getOutput();
    } catch (DiceNotFoundException e) {

      output = e.getMessage();
    }

    channel.sendMessage(output).queue();
  }
}
