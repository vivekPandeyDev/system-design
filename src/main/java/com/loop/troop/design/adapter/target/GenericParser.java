package com.loop.troop.design.adapter.target;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Target interface for all file parsers.
 * Returns a List of records where each record is a Map<column, value>.
 */
public interface GenericParser {
    List<Map<String, Object>> parse(String resourcePath) throws IOException;
}
