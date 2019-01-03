package org.wharagaradoo.dndbro.database;

import org.wharagaradoo.dndbro.enums.Stats;
import org.wharagaradoo.dndbro.model.Character;

import java.util.List;
import java.util.Map;
import java.util.Set;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-31. */
public class DatabaseCommand {

  public static Character getCharacter() {

    PostgreClient.getQueryResult("");

    return null;
  }

  public static void createCharacter(Character character, String userId) {

    // delete existing data by userId
    List<Map<String, Object>> queryResult =
        PostgreClient.getQueryResult("SELECT char_id FROM characters WHERE userid = ?", userId);

    if (!queryResult.isEmpty()) {
      PostgreClient.getQueryResult("DELETE FROM characters WHERE userid = ?", userId);
    }

    // characters
    PostgreClient.getQueryResult(
        "INSERT INTO characters (userid, charname, level, ac) VALUES (?, ?, ?, ?)",
        userId,
        character.getName(),
        character.getLevel(),
        character.getArmorClass());

    List<Map<String, Object>> queryResult1 =
        PostgreClient.getQueryResult("SELECT char_id FROM characters WHERE userid = ?", userId);

    int charId = (int) queryResult1.get(0).get("char_id");

    // characteristics
    Map<Stats, Integer> stats = character.getStats();

    PostgreClient.getQueryResult(
        "INSERT INTO characteristics (char_id, DEX, STR, CON, INT, WIS, CHA) VALUES (?, ?, ?, ?, ?, ?, ?)",
        charId,
        stats.get(Stats.DEX),
        stats.get(Stats.STR),
        stats.get(Stats.CON),
        stats.get(Stats.INT),
        stats.get(Stats.WIS),
        stats.get(Stats.CHA));

    // proficiencies
    Set<String> proficiencies = character.getProficiencies();
    String join = String.join(", ", proficiencies);

    PostgreClient.getQueryResult(
        "INSERT INTO proficiencies (char_id, proficiencies) VALUES (?, ?)", charId, join);

    // immunities
    Set<String> immunities = character.getImmunities();
    join = String.join(", ", immunities);

    PostgreClient.getQueryResult(
        "INSERT INTO immunities (char_id, immunities) VALUES (?, ?)", charId, join);

    // resistances
    Set<String> resistances = character.getResistances();
    join = String.join(", ", resistances);

    PostgreClient.getQueryResult(
        "INSERT INTO resistances (char_id, resistances) VALUES (?, ?)", charId, join);
  }
}
