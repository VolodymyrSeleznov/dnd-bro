package org.wharagaradoo.dndbro.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.wharagaradoo.dndbro.data.Bestiary;
import org.wharagaradoo.dndbro.model.monster.Monster;
import org.wharagaradoo.dndbro.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-06. */
public class Finder {

  public static JsonArray search(JsonArray jsonArray, String query) {
    JsonArray result = new JsonArray();
    for (JsonElement json : jsonArray) {
      if (json.getAsJsonObject()
          .get("name")
          .getAsString()
          .toLowerCase()
          .contains(query.toLowerCase())) {
        result.add(json);
      }
    }

    return result;
  }
}
