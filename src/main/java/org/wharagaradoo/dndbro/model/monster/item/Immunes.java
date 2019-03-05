package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.wharagaradoo.dndbro.util.json.ImmunesDeserializer;

import java.util.ArrayList;
import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ImmunesDeserializer.class)
public class Immunes {

  private List<String> physicalImmunities = new ArrayList<>();
  private List<String> magicalImmunities = new ArrayList<>();

  public List<String> getMagicalImmunities() {
    return magicalImmunities;
  }

  public void setMagicalImmunity(String magicalImmunity) {
    this.magicalImmunities.add(magicalImmunity);
  }

  public void setPhysicalImmunity(String physicalImmunity) {

    physicalImmunities.add(physicalImmunity);
  }

  @Override
  public String toString() {
    return "PhysicalImmunities:"
        + physicalImmunities
        + "; "
        + "MagicalImmunities:"
        + magicalImmunities;
  }

  public String[] getPhysicalImmunities() {

    return physicalImmunities.toArray(new String[0]);
  }
}
