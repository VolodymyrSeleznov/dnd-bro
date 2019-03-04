package org.wharagaradoo.dndbro.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.wharagaradoo.dndbro.cache.JsonCacher;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-21. */
public class Bestiary {

  private static JsonArray bestiary;

  public static JsonArray getBestiary() {

    if (bestiary == null) {
      String sBestiary =
          JsonCacher.getFileContent("src/main/java/org/wharagaradoo/dndbro/cache/bestiary.json");
      bestiary =
          new JsonParser().parse(sBestiary).getAsJsonObject().get("monster").getAsJsonArray();
    }

    return bestiary;
  }
}
