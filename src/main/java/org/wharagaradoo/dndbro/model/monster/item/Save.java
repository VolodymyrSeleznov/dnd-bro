package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Save {

    @JsonProperty("str")
    private int str;
    @JsonProperty("dex")
    private int dex;
    @JsonProperty("con")
    private int con;
    @JsonProperty("int")
    private int intellect;
    @JsonProperty("wis")
    private int wis;
    @JsonProperty("cha")
    private int cha;
}
