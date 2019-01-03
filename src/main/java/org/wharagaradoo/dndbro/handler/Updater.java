package org.wharagaradoo.dndbro.handler;

import org.wharagaradoo.dndbro.database.DatabaseCommand;
import org.wharagaradoo.dndbro.model.Character;
import org.wharagaradoo.dndbro.parser.DndBeyondParser;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-30. */
public class Updater {

  public static Character createCharacter(String command, String userId) {
    String url = command.split(" ")[1];

    String[] urlArr = url.split("/");
    String id = urlArr[urlArr.length - 1];

    url = "https://www.dndbeyond.com/character/" + id + "/json";

    Character character = DndBeyondParser.parseUrl(url);
    DatabaseCommand.createCharacter(character, userId);

    return character;
  }
}
