package org.wharagaradoo.dndbro.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;
import org.wharagaradoo.dndbro.enums.Stats;
import org.wharagaradoo.dndbro.model.Character;

import java.io.IOException;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-30. */
public class DndBeyondParser {

  public static void main(String[] args) throws IOException {
    String json =
        Jsoup.connect("https://www.dndbeyond.com/character/7204016/json")
            .ignoreContentType(true)
            .execute()
            .body();
    JsonElement jelement = new JsonParser().parse(json);
    JsonObject jobject = jelement.getAsJsonObject();
    JsonElement stats = jobject.get("stats");
    JsonArray asJsonArray = stats.getAsJsonArray();

    Character character = new Character();

    for (JsonElement jsonElement : asJsonArray) {
      int id = jsonElement.getAsJsonObject().get("id").getAsInt();
      int value = jsonElement.getAsJsonObject().get("value").getAsInt();
      character.setStat(Stats.getByIndex(id), value);
    }
    System.out.println();
  }
}
