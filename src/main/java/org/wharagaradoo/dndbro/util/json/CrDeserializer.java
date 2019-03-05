package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.wharagaradoo.dndbro.model.monster.item.Cr;

import java.io.IOException;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-03-04. */
public class CrDeserializer extends JsonDeserializer<Cr> {
  @Override
  public Cr deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {

    Cr cr = new Cr();
    TreeNode treeNode = p.readValueAsTree();

    if (treeNode.isValueNode()) {
        TextNode crNode = (TextNode) treeNode;
        cr.setCr(crNode.asText());
    } else {
      TextNode crNode = (TextNode) treeNode.get("ac");
      TextNode lairNode = (TextNode) treeNode.get("lair");
      cr.setCr(crNode.asText());
      cr.setLair(lairNode.asText());
    }

    return cr;
  }
}
