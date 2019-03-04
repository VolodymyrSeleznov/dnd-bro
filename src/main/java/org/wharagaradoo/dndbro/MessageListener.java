package org.wharagaradoo.dndbro;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.wharagaradoo.dndbro.cache.JsonCacher;
import org.wharagaradoo.dndbro.handler.Updater;
import org.wharagaradoo.dndbro.statemachine.StateMachine;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2018-12-28. */
public class MessageListener extends ListenerAdapter {

  public static Map<User, StateMachine> stateMachines = new HashMap<>();

  public static void main(String[] args) {
    JsonCacher.cache();
    try {
      JDA jda =
          new JDABuilder("NTI3NTQ0OTg5MjY2NDc3MDU2.DwZYpw.FkLpur7_P6_QKES9s5H1NtTwPFs")
              .addEventListener(new MessageListener())
              .build();
      jda.awaitReady();
      System.out.println("Finished Building JDA!");
    } catch (LoginException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onMessageReceived(MessageReceivedEvent event) {
    JDA jda = event.getJDA();
    long responseNumber = event.getResponseNumber();
    User author = event.getAuthor();
    Message message = event.getMessage();
    MessageChannel channel = event.getChannel();
    String msg = message.getContentDisplay();
    boolean bot = author.isBot();

    StateMachine stateMachine = stateMachines.get(author);
    if (stateMachine != null && stateMachine.updateState(event)) {
      stateMachines.remove(author);

      return;
    }

    if (event.isFromType(ChannelType.TEXT)) {
      Guild guild = event.getGuild();
      TextChannel textChannel = event.getTextChannel();
      Member member = event.getMember();
      String name;

      if (message.isWebhookMessage()) {
        name = author.getName();

      } else {
        name = member.getEffectiveName();
      }

      System.out.printf("(%s)[%s]<%s>: %s\n", guild.getName(), textChannel.getName(), name, msg);

    } else if (event.isFromType(ChannelType.PRIVATE)) {
      PrivateChannel privateChannel = event.getPrivateChannel();
      System.out.printf("[PRIV]<%s>: %s\n", author.getName(), msg);

    } else if (event.isFromType(ChannelType.GROUP)) {
      Group group = event.getGroup();
      String groupName = group.getName() != null ? group.getName() : "";
      System.out.printf("[GRP: %s]<%s>: %s\n", groupName, author.getName(), msg);
    }

    if (msg.equals("!ping")) {
      channel.sendMessage("pong!").queue();

    } else if (msg.startsWith("!roll")) {
      new DiceRollListener(event).process();
    } else if (msg.startsWith("!beyond")) {
      Updater.createCharacter(msg, author.getId());
    } else if (msg.startsWith("!minfo")) {
      new MonsterListener(event).process();
    }
  }
}
