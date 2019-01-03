package org.wharagaradoo.dndbro.parser;

import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-03.
 */
public class BestiaryParser {

  public static void main(String[] args) {
    String json = null;
    try {
      json = Jsoup.connect("https://5etools.com/data/bestiary/bestiary-dmg.json").ignoreContentType(true).execute().body();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
