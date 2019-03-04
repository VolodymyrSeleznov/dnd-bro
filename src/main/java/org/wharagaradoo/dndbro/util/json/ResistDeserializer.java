package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.wharagaradoo.dndbro.model.monster.item.Resists;

import java.io.IOException;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-21. */
public class ResistDeserializer extends JsonDeserializer<Resists> {
  @Override
  public Resists deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    Resists resists = new Resists();

    TreeNode treeNode = p.readValueAsTree();

    if (treeNode.isArray()) {
      for (JsonNode jsonNode : (ArrayNode) treeNode) {
        if (jsonNode.isObject()) {
          ArrayNode arrayNode = (ArrayNode) jsonNode.get("resist");
          if (arrayNode == null) {
            continue;
          }
          for (JsonNode immuneNode : arrayNode) {
            resists.setPhysicalResist(immuneNode.asText());
          }
        } else {

          TextNode textNode = (TextNode) jsonNode;
          resists.setMagicalResist(textNode.asText());
        }
      }
    }

    return resists;
  }
}
