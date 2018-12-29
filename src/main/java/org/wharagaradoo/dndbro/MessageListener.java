package org.wharagaradoo.dndbro;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import org.wharagaradoo.dndbro.handler.DiceRoller;

import javax.security.auth.login.LoginException;

/** @author Created by Vladimir Seleznov [v.e.seleznov@gmail.com] on 2018-12-28. */
@SuppressWarnings("Duplicates")
public class MessageListener extends ListenerAdapter {

  public static void main(String[] args) {
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
      channel.sendMessage(DiceRoller.processMessage(msg)).queue();
    }
  }
}
