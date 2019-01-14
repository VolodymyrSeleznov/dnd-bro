package org.wharagaradoo.dndbro.model.monster;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.wharagaradoo.dndbro.model.monster.item.*;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Monster {

    @JsonProperty("name")
    private String name;
    @JsonProperty("size")
    private String size;
    @JsonProperty("type")
    private String type;
    @JsonProperty("source")
    private String source;
    @JsonProperty("alignment")
    private String[] alignment;
    @JsonProperty("ac")
    private Ac[] ac;
    @JsonProperty("hp")
    private Hp hp;
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
    @JsonProperty("save")
    private Save save;
    @JsonProperty("resist")
    private Resist[] resist;
    @JsonProperty("immune")
    private Immune[] immune;
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")
//    @JsonProperty("")

}
