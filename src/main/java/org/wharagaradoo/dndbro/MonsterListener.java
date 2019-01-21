package org.wharagaradoo.dndbro;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.wharagaradoo.dndbro.data.Bestiary;
import org.wharagaradoo.dndbro.model.monster.Monster;
import org.wharagaradoo.dndbro.statemachine.MonsterFinderStateMachine;
import org.wharagaradoo.dndbro.util.Finder;
import org.wharagaradoo.dndbro.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-15. */
public class MonsterListener {

  private final MessageChannel channel;
  private final String msg;
  private Monster monster;
  private MessageReceivedEvent event;

  public MonsterListener(MessageReceivedEvent event) {

    channel = event.getChannel();
    msg = event.getMessage().getContentDisplay();
    this.event = event;
  }

  public Monster getMonster() {
    return monster;
  }

  public void setMonster(Monster monster) {
    this.monster = monster;
  }

  private void findMonster(String monsterName) {
    List<Monster> monsters = new ArrayList<>();
    JsonArray bestiary = Bestiary.getBestiary();
    JsonArray searchResults = Finder.search(bestiary, monsterName);

    for (JsonElement searchResult : searchResults) {
      monsters.add(JsonUtil.fromJson(Monster.class, searchResult.toString()));
    }

    if (monsters.size() > 1) {
      new MonsterFinderStateMachine(monsters, event, this);
    } else {
      monster = monsters.get(0);
    }
  }

  public void process() {
    if (msg.startsWith("!minfo")) {
      String monsterName = msg.substring(msg.indexOf(' ') + 1);

      findMonster(monsterName);
      sendOutput();
    }
  }

  public void sendOutput() {
    if (monster != null) {
      channel.sendMessage(monster.getActions()[0].getEntries()[0]).queue();
    }
  }
}
