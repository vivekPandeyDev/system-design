package com.loop.troop.design.adapter.adaptee;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loop.troop.design.adapter.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JsonParserAdapter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Map<String, Object>> parseJson(String resourcePath) throws IOException {
        try (InputStream is = ResourceLoader.getResourceAsStream(resourcePath)) {
            return objectMapper.readValue(is, new TypeReference<>() {
            });
        }
    }
}
