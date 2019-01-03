package org.wharagaradoo.dndbro.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jsoup.Jsoup;
import org.wharagaradoo.dndbro.enums.Stats;
import org.wharagaradoo.dndbro.model.Character;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-30. */
public class DndBeyondParser {

  public static Character parseUrl(String url) {
    String json = null;
    try {
      json = Jsoup.connect(url).ignoreContentType(true).execute().body();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Character character = new Character();
    JsonElement jelement = new JsonParser().parse(Objects.requireNonNull(json));

    // name
    String name = jelement.getAsJsonObject().get("name").getAsString();
    character.setName(name);

    // stats
    JsonArray asJsonArray = jelement.getAsJsonObject().get("stats").getAsJsonArray();
    for (JsonElement jsonElement : asJsonArray) {
      int id = jsonElement.getAsJsonObject().get("id").getAsInt();
      int value = jsonElement.getAsJsonObject().get("value").getAsInt();
      character.setStat(Stats.getByIndex(id), value);
    }

    // profs and stuff
    List<String> modifierSources = new ArrayList<>();
    modifierSources.add("race");
    modifierSources.add("class");
    modifierSources.add("background");
    modifierSources.add("item");
    modifierSources.add("feat");
    modifierSources.add("condition");

    JsonObject modifiers = jelement.getAsJsonObject().get("modifiers").getAsJsonObject();

    for (String modifierSource : modifierSources) {
      JsonArray allModifiersOfSource = modifiers.get(modifierSource).getAsJsonArray();
      for (JsonElement modifierOfSource : allModifiersOfSource) {
        JsonObject modifierOfSourceObject = modifierOfSource.getAsJsonObject();
        String type = modifierOfSourceObject.get("type").getAsString();
        String subType = modifierOfSourceObject.get("subType").getAsString();
        switch (type) {
          case "immunity":
            character.setImmunity(subType);
            break;
          case "resistance":
            character.setResistance(subType);
            break;
          case "proficiency":
            character.setProficiency(subType);
            break;
        }
      }
    }

    // level
    int level = 0;
    JsonArray classes = jelement.getAsJsonObject().get("classes").getAsJsonArray();
    for (JsonElement aClass : classes) {
      level += aClass.getAsJsonObject().get("level").getAsInt();
    }
    character.setLevel(level);

    return character;
  }
}
