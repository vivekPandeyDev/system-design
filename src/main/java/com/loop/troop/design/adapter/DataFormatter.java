package com.loop.troop.design.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataFormatter {

    private final ObjectMapper jsonMapper;
    private final XmlMapper xmlMapper;

    public DataFormatter() {
        this.jsonMapper = new ObjectMapper();
        this.xmlMapper = new XmlMapper();
    }

    /**
     * Convert List<Map> to pretty-printed JSON string
     */
    public String toJson(List<Map<String, Object>> data) throws IOException {
        return jsonMapper.writerWithDefaultPrettyPrinter()
                         .writeValueAsString(data);
    }

    /**
     * Convert List<Map> to pretty-printed XML string
     */
    public String toXml(List<Map<String, Object>> data) throws IOException {
        // wrap in a root element to make valid XML
        return xmlMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(data);
    }
}