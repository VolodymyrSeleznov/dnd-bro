package org.wharagaradoo.dndbro.parser;

import com.google.gson.JsonArray;
import org.wharagaradoo.dndbro.model.monster.Monster;
import org.wharagaradoo.dndbro.util.Finder;
import org.wharagaradoo.dndbro.util.json.JsonUtil;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-03. */
public class MonsterParser {

  public static void main(String[] args) {

    JsonArray lizardfolk = Finder.findMonster("Acererak Demilich");

    Monster monster = JsonUtil.fromJson(Monster.class, lizardfolk.get(0).toString());

//    String damageRe = "[+-]?\\d+ \\((.+?)\\) (\\w+) damage";
//    Matcher matcher = Pattern.compile(damageRe).matcher(lizardfolk.get(0).toString());
//


    System.out.println();
  }


}
