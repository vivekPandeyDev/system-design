package com.loop.troop.design.adapter;



import com.loop.troop.design.adapter.target.GenericParser;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

@Log4j2
public class GenericParserClient {

    public static void main(String[] args) throws Exception {
        DataFormatter df = new DataFormatter();
        // JSON
        GenericParser jsonParser = new JsonToGenericAdapter();
        List<Map<String, Object>> jsonData = jsonParser.parse("data/sample.json");
        log.info("JSON Data: \n{}", df.toJson(jsonData));

        // XML
        GenericParser xmlParser = new XmlToGenericAdapter();
        List<Map<String, Object>> xmlData = xmlParser.parse("data/sample.xml");
        log.info("XML  Data: \n{}", df.toXml(xmlData));
    }
}
