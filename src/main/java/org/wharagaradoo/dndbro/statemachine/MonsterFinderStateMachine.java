package org.wharagaradoo.dndbro.statemachine;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.wharagaradoo.dndbro.MessageListener;
import org.wharagaradoo.dndbro.MonsterListener;
import org.wharagaradoo.dndbro.model.monster.Monster;

import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-16. */
public class MonsterFinderStateMachine implements StateMachine {

  private final List<Monster> monsters;
  private final MonsterListener monsterListener;
  private int state;

  public MonsterFinderStateMachine(
      List<Monster> monsters, MessageReceivedEvent event, MonsterListener monsterListener) {

    this.monsters = monsters;
    this.monsterListener = monsterListener;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Please specify an option");
    for (int i = 0; i < monsters.size(); i++) {
      Monster monster = monsters.get(i);
      stringBuilder.append("\n/*").append(i).append("*/ ").append(monster.getName());
    }
    MessageChannel channel = event.getChannel();
    channel.sendMessage(stringBuilder).queue();
    state = 0;
    MessageListener.stateMachines.put(event.getAuthor(), this);
  }

  @Override
  public boolean updateState(MessageReceivedEvent event) {
    String msg = event.getMessage().getContentDisplay();
    MessageChannel channel = event.getChannel();

    switch (state) {
      case 0:
        int integer;
        try {
          integer = Integer.parseInt(msg);
        } catch (NumberFormatException e) {

          channel.sendMessage("Selection canceled").queue();

          return true;
        }

        if (integer >= monsters.size()) {
          channel.sendMessage("Selection canceled").queue();

          return true;
        } else {

          monsterListener.setMonster(monsters.get(integer));
          monsterListener.sendOutput();

          return true;
        }
      default:
        return false;
    }
  }
}
