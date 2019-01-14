package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.wharagaradoo.dndbro.util.json.ImmuneDeserializer;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ImmuneDeserializer.class)
public class Immune {

  @JsonProperty("immune")
  private String[] physicalImmune;
  @JsonProperty("note")
  private String note;
  private String[] magicalImmune;

    public void setMagicalImmune(String[] magicalImmune) {
        this.magicalImmune = magicalImmune;
    }

    public void setPhysicalImmune(String[] physicalImmune) {
    this.physicalImmune = physicalImmune;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
