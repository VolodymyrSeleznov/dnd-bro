package org.wharagaradoo.dndbro.util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Objects;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-03. */
public class JsonReceiver {

  public static JsonElement getJsonElement(String url) {

    String json = getJsonString(url);

    return new JsonParser().parse(Objects.requireNonNull(json));
  }

  private static String getJsonString(String url) {

    Client client = ClientBuilder.newBuilder().build();

    return client
        .target(url)
        .request()
        .header("Accept", "application/json,application/vnd.error+json")
        .header("content-type", "application/json")
        .get()
        .readEntity(String.class);
  }
}
