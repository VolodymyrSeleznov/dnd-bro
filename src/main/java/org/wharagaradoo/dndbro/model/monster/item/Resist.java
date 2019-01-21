package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.wharagaradoo.dndbro.util.json.ResistDeserializer;

import java.util.ArrayList;
import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ResistDeserializer.class)
public class Resist {

  private List<String> physicalResists = new ArrayList<>();
  private String magicalResist;
  private String resistType;

  public String[] getPhysicalResists() {
    return physicalResists.toArray(new String[0]);
  }

  public void setPhysicalResist(String physicalResists) {
    this.physicalResists.add(physicalResists);
  }

  public String getMagicalResist() {
    return magicalResist;
  }

  public void setMagicalResist(String magicalResist) {
    this.magicalResist = magicalResist;
  }

  public String getResistType() {
    return resistType;
  }

  public void setResistType(String resistType) {
    this.resistType = resistType;
  }
}
