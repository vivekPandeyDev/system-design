package com.loop.troop.graph;

import lombok.extern.log4j.Log4j2;

import java.util.*;

@Log4j2
class MapGraph implements MutableGraph {
    static {
        GraphFactory.register("map", param -> new MapGraph());
    }

    private final Map<Integer, List<Integer>> adj = new HashMap<>();

    @Override
    public void addVertex(int v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    @Override
    public void addEdge(int from, int to) {
        adj.putIfAbsent(from, new ArrayList<>());
        adj.putIfAbsent(to, new ArrayList<>());
        adj.get(from).add(to);
    }

    @Override
    public void addUndirectedEdge(int v1, int v2) {
        addEdge(v1, v2);
        addEdge(v2, v1);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return adj.getOrDefault(v, Collections.emptyList());
    }

    @Override
    public void printGraph() {
        adj.forEach((k, v) -> log.info("{} -> {}",k,v));
    }

    @Override
    public Set<Integer> getAllVertices() {
        return Map.copyOf(adj).keySet();
    }
}