package org.wharagaradoo.dndbro.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.wharagaradoo.dndbro.util.json.JsonReceiver;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-06. */
public class Finder {

  public static JsonArray findMonster(String monsterName) {
    JsonArray bestiary = getBestiary();

    return search(bestiary, monsterName);
  }

  private static JsonArray getBestiary() {
    JsonArray bestiary = new JsonArray();

    JsonElement jsonElement =
        JsonReceiver.getJsonElement("https://5etools.com/data/bestiary/index.json");
    Set<String> keySet = jsonElement.getAsJsonObject().keySet();
    List<String> urls =
        keySet
            .stream()
            .map(source -> jsonElement.getAsJsonObject().get(source).getAsString())
            .collect(Collectors.toList());
    urls =
        urls.stream()
            .map(url -> "https://5etools.com/data/bestiary/" + url)
            .collect(Collectors.toList());
    urls.stream()
        .map(
            url ->
                JsonReceiver.getJsonElement(url).getAsJsonObject().get("monster").getAsJsonArray())
        .forEach(bestiary::addAll);

    return bestiary;
  }

  private static JsonArray search(JsonArray jsonArray, String query) {
    JsonArray result = new JsonArray();
    for (JsonElement json : jsonArray) {
      if (json.getAsJsonObject().get("name").getAsString().startsWith(query)) {
        result.add(json);
      }
    }

    return result;
  }
}
