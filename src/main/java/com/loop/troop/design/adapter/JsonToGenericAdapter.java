package com.loop.troop.design.adapter;



import com.loop.troop.design.adapter.adaptee.JsonParserAdapter;
import com.loop.troop.design.adapter.target.GenericParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonToGenericAdapter implements GenericParser {
    private final JsonParserAdapter jsonParser = new JsonParserAdapter();

    @Override
    public List<Map<String, Object>> parse(String resourcePath) throws IOException {
        return jsonParser.parseJson(resourcePath);
    }
}
