package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.wharagaradoo.dndbro.util.json.CrDeserializer;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-15. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = CrDeserializer.class)
public class Cr {

  @JsonProperty("cr")
  private String cr;

  @JsonProperty("lair")
  private String lair;

  public String getCr() {
    return cr;
  }

  public void setCr(String cr) {
    this.cr = cr;
  }

  @Override
  public String toString() {

    return "CR: " + cr + "; " + "Lair: " + lair;
  }

  public String getLair() {
    return lair;
  }

  public void setLair(String lair) {
    this.lair = lair;
  }
}
