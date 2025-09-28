package com.loop.troop.design.adapter.adaptee;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.loop.troop.design.adapter.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class XmlParserAdapter {
    private final XmlMapper xmlMapper = new XmlMapper();

    public List<Map<String, Object>> parseXml(String resourcePath) throws IOException {
        try (InputStream is = ResourceLoader.getResourceAsStream(resourcePath)) {
            return xmlMapper.readValue(
                    is,
                    xmlMapper.getTypeFactory().constructCollectionType(List.class, Map.class)
            );
        }
    }
}
