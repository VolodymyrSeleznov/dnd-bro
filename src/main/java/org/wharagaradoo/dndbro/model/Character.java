package org.wharagaradoo.dndbro.model;

import org.wharagaradoo.dndbro.enums.Stats;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-30. */
public class Character {

  private int hp;
  private int level;
  private int armorClass;
  private String name;
  private Set<String> resistances = new HashSet<>();
  private Set<String> immunities = new HashSet<>();
  private Set<String> proficiencies = new HashSet<>();
  private Map<Stats, Integer> stats = new HashMap<>();
  private int initiative;

  public Character() {
    stats.put(Stats.STR, 0);
    stats.put(Stats.DEX, 0);
    stats.put(Stats.CON, 0);
    stats.put(Stats.INT, 0);
    stats.put(Stats.WIS, 0);
    stats.put(Stats.CHA, 0);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<String> getProficiencies() {
    return proficiencies;
  }

  public void setProficiency(String proficiency) {

    proficiencies.add(proficiency);
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getArmorClass() {
    return armorClass;
  }

  public void setArmorClass(int armorClass) {
    this.armorClass = armorClass;
  }

  public Set<String> getResistances() {
    return resistances;
  }

  public void setResistance(String resistance) {
    resistances.add(resistance);
  }

  public Set<String> getImmunities() {
    return immunities;
  }

  public void setImmunity(String immunity) {
    immunities.add(immunity);
  }

  public Map<Stats, Integer> getStats() {
    return stats;
  }

  public void setStat(Stats stat, int value) {

    stats.put(stat, value);
  }
}
