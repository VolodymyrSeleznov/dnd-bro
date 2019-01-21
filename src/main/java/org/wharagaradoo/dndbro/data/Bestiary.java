package org.wharagaradoo.dndbro.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.wharagaradoo.dndbro.util.json.JsonReceiver;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-21.
 */
public class Bestiary {

    public static JsonArray getBestiary() {
      JsonArray bestiary = new JsonArray();

      JsonElement jsonElement =
          JsonReceiver.getJsonElement("https://5etools.com/data/bestiary/index.json");
      Set<String> keySet = jsonElement.getAsJsonObject().keySet();
      List<String> urls =
          keySet.stream()
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
}
