package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.wharagaradoo.dndbro.model.monster.item.Resist;

import java.io.IOException;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-21. */
public class ResistDeserializer extends JsonDeserializer<Resist> {
  @Override
  public Resist deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    Resist resist = new Resist();

    TreeNode treeNode = p.readValueAsTree();
    if (treeNode.isObject()) {
      ArrayNode arrayNode = (ArrayNode) treeNode.get("resist");
      for (JsonNode jsonNode : arrayNode) {
        resist.setPhysicalResist(jsonNode.asText());
      }
      resist.setResistType("physical");

    } else if (treeNode.isValueNode()) {
      TextNode textNode = (TextNode) treeNode;
      resist.setMagicalResist(textNode.asText());
      resist.setResistType("magical");
    }

    return resist;
  }
}
