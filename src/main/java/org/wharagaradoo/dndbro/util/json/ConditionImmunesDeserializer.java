package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.wharagaradoo.dndbro.model.monster.item.ConditionImmunes;

import java.io.IOException;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-02-25. */
public class ConditionImmunesDeserializer extends JsonDeserializer<ConditionImmunes> {

  @Override
  public ConditionImmunes deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {

    ConditionImmunes conditionImmunes = new ConditionImmunes();

    TreeNode treeNode = p.readValueAsTree();

    if (treeNode.isObject()) {
      treeNode = treeNode.get("conditionImmune");
    }

    for (JsonNode jsonNode : (ArrayNode) treeNode) {
      conditionImmunes.setConditionImmune(jsonNode.asText());
    }

    return conditionImmunes;
  }
}
