package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cr {

    @JsonProperty("cr")
    private String cr;
    @JsonProperty("lair")
    private String lair;
}
