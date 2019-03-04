package org.wharagaradoo.dndbro.cache;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.wharagaradoo.dndbro.util.json.JsonReceiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-21. */
public class JsonCacher {

  public static void cache() {
    cacheBestiary();
  }

  private static JsonArray cacheBestiary() {
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

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("monster", bestiary);

    try (PrintWriter printWriter =
        new PrintWriter(new File("src/main/java/org/wharagaradoo/dndbro/cache/bestiary.json"))) {
      printWriter.println(jsonObject.toString());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return bestiary;
  }

  public static String getFileContent(String filePath) {

    byte[] encoded = new byte[0];
    try {
      encoded = Files.readAllBytes(Paths.get(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new String(encoded, StandardCharsets.UTF_8);
  }
}
