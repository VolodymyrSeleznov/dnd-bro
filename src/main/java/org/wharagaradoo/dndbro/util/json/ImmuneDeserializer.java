package org.wharagaradoo.dndbro.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.wharagaradoo.dndbro.model.monster.item.Immune;

import java.io.IOException;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-11.
 */
public class ImmuneDeserializer extends JsonDeserializer<Immune> {
    @Override
    public Immune deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Immune immune = new Immune();

        TreeNode treeNode = p.readValueAsTree();

        return immune;

    }
}
