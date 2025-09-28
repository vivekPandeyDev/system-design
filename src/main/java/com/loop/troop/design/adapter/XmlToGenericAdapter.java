package com.loop.troop.design.adapter;



import com.loop.troop.design.adapter.adaptee.XmlParserAdapter;
import com.loop.troop.design.adapter.target.GenericParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class XmlToGenericAdapter implements GenericParser {
    private final XmlParserAdapter xmlParser = new XmlParserAdapter();

    @Override
    public List<Map<String, Object>> parse(String resourcePath) throws IOException {
        return xmlParser.parseXml(resourcePath);
    }
}
