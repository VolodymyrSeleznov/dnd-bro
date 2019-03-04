package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-22. */
public class TypeDeserializer extends JsonDeserializer<String> {
  @Override
  public String deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {

    TreeNode treeNode = p.readValueAsTree();

    if (treeNode.isObject()) {
      TextNode type = (TextNode) treeNode.get("type");

      return type.asText();

    } else if (treeNode.isValueNode()) {
      TextNode textNode = (TextNode) treeNode;

      return textNode.asText();
    }

    return null;
  }
}
