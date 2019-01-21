package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.wharagaradoo.dndbro.util.json.ImmuneDeserializer;

import java.util.ArrayList;
import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ImmuneDeserializer.class)
public class Immune {

  private List<String> physicalImmunities = new ArrayList<>();
  private String magicalImmunity;
  private String immuneType;

  public String getMagicalImmunity() {

    return magicalImmunity;
  }

  public void setMagicalImmunity(String magicalImmunity) {
    this.magicalImmunity = magicalImmunity;
  }

  public void setPhysicalImmunity(String physicalImmunity) {

    physicalImmunities.add(physicalImmunity);
  }

  public String[] getPhysicalImmunities() {

    return physicalImmunities.toArray(new String[0]);
  }

  public String getImmuneType() {
    return immuneType;
  }

  public void setImmuneType(String immuneType) {
    this.immuneType = immuneType;
  }
}
