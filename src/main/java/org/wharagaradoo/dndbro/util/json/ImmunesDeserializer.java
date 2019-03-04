package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.wharagaradoo.dndbro.model.monster.item.Immunes;

import java.io.IOException;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11. */
public class ImmunesDeserializer extends JsonDeserializer<Immunes> {

  @Override
  public Immunes deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    Immunes immunes = new Immunes();

    TreeNode treeNode = p.readValueAsTree();

    if (treeNode.isArray()) {
      for (JsonNode jsonNode : (ArrayNode) treeNode) {
        if (jsonNode.isObject()) {
          ArrayNode arrayNode = (ArrayNode) jsonNode.get("immune");
          for (JsonNode immuneNode : arrayNode) {
            immunes.setPhysicalImmunity(immuneNode.asText());
          }
        } else {

          TextNode textNode = (TextNode) jsonNode;
          immunes.setMagicalImmunity(textNode.asText());
        }
      }
    }

    return immunes;
  }
}
