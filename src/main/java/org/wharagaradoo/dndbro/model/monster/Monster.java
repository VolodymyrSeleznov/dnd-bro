package org.wharagaradoo.dndbro.model.monster;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.wharagaradoo.dndbro.model.monster.item.*;
import org.wharagaradoo.dndbro.util.json.TypeDeserializer;

import java.util.Arrays;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Monster {

  @JsonProperty("name")
  private String name;

  @JsonProperty("size")
  private String size;

  @JsonProperty("type")
  @JsonDeserialize(using = TypeDeserializer.class)
  private String type;

  @JsonProperty("source")
  private String source;

  @JsonProperty("ac")
  private Ac acs;

  @JsonProperty("hp")
  private Hp hp;

  @JsonProperty("str")
  private int str;

  @JsonProperty("dex")
  private int dex;

  @JsonProperty("con")
  private int con;

  @JsonProperty("int")
  private int intellect;

  @JsonProperty("wis")
  private int wis;

  @JsonProperty("cha")
  private int cha;

  @JsonProperty("save")
  private Save save;

  @JsonProperty("resist")
  private Resists resists;

  @JsonProperty("immune")
  private Immunes immunes;

  @JsonProperty("conditionImmune")
  private ConditionImmunes conditionImmunes;

  @JsonProperty("senses")
  private String senses;

  @JsonProperty("passive")
  private int passive;

  @JsonProperty("cr")
  private Cr cr;

  @JsonProperty("trait")
  private Feature[] traits;

  @JsonProperty("action")
  private Feature[] actions;

  @JsonProperty("legendary")
  private Feature[] legendaries;

  @JsonProperty("legendaryGroup")
  private LegendaryGroup legendaryGroup;

  @JsonProperty("page")
  private int page;

  @JsonProperty("traitTags")
  private String[] traitTags;

  @JsonProperty("senseTags")
  private String[] senseTags;

  public String getName() {
    return name;
  }

  public String getSize() {
    return size;
  }

  public String getType() {
    return type;
  }

  public String getSource() {
    return source;
  }

  public Ac getAcs() {
    return acs;
  }

  public Hp getHp() {
    return hp;
  }

  public int getStr() {
    return str;
  }

  public int getDex() {
    return dex;
  }

  public int getCon() {
    return con;
  }

  public int getIntellect() {
    return intellect;
  }

  public int getWis() {
    return wis;
  }

  public int getCha() {
    return cha;
  }

  public Save getSave() {
    return save;
  }

  public Resists getResists() {
    return resists;
  }

  public Immunes getImmunes() {
    return immunes;
  }

  public ConditionImmunes getConditionImmunes() {
    return conditionImmunes;
  }

  public String getSenses() {
    return senses;
  }

  public int getPassive() {
    return passive;
  }

  public Cr getCr() {
    return cr;
  }

  public Feature[] getTraits() {
    return traits;
  }

  public Feature[] getActions() {
    return actions;
  }

  public Feature[] getLegendaries() {
    return legendaries;
  }

  public LegendaryGroup getLegendaryGroup() {
    return legendaryGroup;
  }

  public int getPage() {
    return page;
  }

  public String[] getTraitTags() {
    return traitTags;
  }

  public String[] getSenseTags() {
    return senseTags;
  }

  @Override
  public String toString() {
    return "**Name:** "
        + name
        + "\n"
        + "**Size:** "
        + size
        + "\n"
        + "**Type:** "
        + type
        + "\n"
        + "**Source:** "
        + source
        + "\n"
        + "**Acs:** "
        + acs
        + "\n"
        + "**Hp:** "
        + hp
        + "\n"
        + "**Str:** "
        + str
        + "\n"
        + "**Dex:** "
        + dex
        + "\n"
        + "**Con:** "
        + con
        + "\n"
        + "**Intellect:** "
        + intellect
        + "\n"
        + "**Wis:** "
        + wis
        + "\n"
        + "**Cha:** "
        + cha
        + "\n"
        + "**Save:** "
        + save
        + "\n"
        + "**Resists:** "
        + resists
        + "\n"
        + "**Immunes:** "
        + immunes
        + "\n"
        + "**ConditionImmunes:** "
        + conditionImmunes
        + "\n"
        + "**Senses:** "
        + senses
        + "\n"
        + "**Passive:** "
        + passive
        + "\n"
        + "**Cr:** "
        + cr
        + "\n"
        + "**Traits:**\n"
        + Arrays.toString(traits)
        + "\n"
        + "**Actions:**\n"
        + Arrays.toString(actions)
        + "\n"
        + "**Legendaries:**\n"
        + Arrays.toString(legendaries)
        + "\n"
        + "**LegendaryGroup:** "
        + legendaryGroup
        + "\n"
        + "**Page:** "
        + page
        + "\n"
        + "**TraitTags:** "
        + Arrays.toString(traitTags)
        + "\n"
        + "**SenseTags:** "
        + Arrays.toString(senseTags);
  }
}
