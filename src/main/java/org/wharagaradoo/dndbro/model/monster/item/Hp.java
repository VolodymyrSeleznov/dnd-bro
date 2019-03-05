package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.wharagaradoo.dndbro.util.Dice;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hp {

  @JsonProperty("average")
  private int average;

  @JsonProperty("formula")
  private Dice formula;

  @Override
  public String toString() {
    return "Average:" + average + "; " + "Formula:" + formula;
  }

  public int getAverage() {

    return average;
  }

  public void setAverage(int average) {
    this.average = average;
  }

  public Dice getFormula() {

    return formula;
  }

  public void setFormula(Dice formula) {
    this.formula = formula;
  }
}
