package org.wharagaradoo.dndbro.model.monster.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ac {

    @JsonProperty("ac")
    private int ac;
    @JsonProperty("from")
    private String[] from;
}
