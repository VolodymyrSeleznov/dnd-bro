package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fly {

  @JsonProperty("number")
  private int number;

  @JsonProperty("condition")
  private String condition;

  @Override
  public String toString() {
    return "Number: " + number + ";" + "Condition:" + condition;
  }
}
