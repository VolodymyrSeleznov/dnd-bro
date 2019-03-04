package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.wharagaradoo.dndbro.util.json.ConditionImmunesDeserializer;

import java.util.ArrayList;
import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-02-25. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ConditionImmunesDeserializer.class)
public class ConditionImmunes {

  private List<String> conditionImmunes = new ArrayList<>();

  public List<String> getConditionImmunes() {
    return conditionImmunes;
  }

  public void setConditionImmune(String conditionImmune) {
    conditionImmunes.add(conditionImmune);
  }
}
