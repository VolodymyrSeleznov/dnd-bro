package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.wharagaradoo.dndbro.util.Dice;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hp {

    @JsonProperty("average")
    private int average;
    @JsonProperty("formula")
    private Dice formula;

}
