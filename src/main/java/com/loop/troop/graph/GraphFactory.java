package com.loop.troop.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

class GraphFactory {
    private static final Map<String, IntFunction<Graph>> registry = new HashMap<>();

    private GraphFactory() {}

    public static void register(String key, IntFunction<Graph> creator) {
        registry.put(key, creator);
    }

    public static Graph create(String key,int param) {
        IntFunction<Graph> creator = registry.get(key);
        if (creator == null) {
            throw new IllegalArgumentException("Unknown graph type: " + key);
        }
        return creator.apply(param);
    }
}