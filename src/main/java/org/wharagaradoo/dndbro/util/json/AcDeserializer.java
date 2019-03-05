package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import org.wharagaradoo.dndbro.model.monster.item.Ac;

import java.io.IOException;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-22. */
public class AcDeserializer extends JsonDeserializer<Ac> {
  @Override
  public Ac deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

    Ac ac = new Ac();
    TreeNode treeNode = p.readValueAsTree();

    TreeNode acNode = treeNode.get(0);

    IntNode intNode;
    if (acNode.isValueNode()) {
      intNode = (IntNode) acNode;
    } else {
      intNode = (IntNode) acNode.get("ac");
    }

    ac.setAc(intNode.asInt());

    return ac;
  }
}
