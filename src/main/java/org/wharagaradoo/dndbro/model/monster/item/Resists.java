package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.wharagaradoo.dndbro.util.json.ResistDeserializer;

import java.util.ArrayList;
import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ResistDeserializer.class)
public class Resists {

  private List<String> physicalResists = new ArrayList<>();
  private List<String> magicalResists = new ArrayList<>();

  public String[] getPhysicalResists() {
    return physicalResists.toArray(new String[0]);
  }

  public void setPhysicalResist(String physicalResists) {
    this.physicalResists.add(physicalResists);
  }

  public List<String> getMagicalResists() {
    return magicalResists;
  }

  public void setMagicalResist(String magicalResists) {
    this.magicalResists.add(magicalResists);
  }

}
