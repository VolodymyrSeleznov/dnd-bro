package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
public class JsonUtil {

  private JsonUtil() {}

  public static <T> T fromJson(final TypeReference<T> type, final String jsonObject) {
    T data;

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      data = objectMapper.readValue(jsonObject, type);
    } catch (Exception e) {
      e.printStackTrace();
      data = null;
    }

    return data;
  }

  public static <T> T fromJson(Class<T> objectClass, String jsonObject) {
    T data;

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      data = objectMapper.readValue(jsonObject, objectClass);
      System.out.println(jsonObject);
    } catch (IOException e) {
      e.printStackTrace();
      data = null;
    }

    return data;
  }

  public static String toJson(Object jsonObject) {
    String data;

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      data = objectMapper.writeValueAsString(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      data = null;
    }

    return data;
  }
}
