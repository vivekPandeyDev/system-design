package com.loop.troop.graph;

import lombok.extern.log4j.Log4j2;

import java.util.*;
import java.util.stream.Collectors;

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
        StringBuilder sb = new StringBuilder();
        sb.append("Graph adjacency list (MapGraph):\n");
        sb.append("--------------------------------\n");

        // Process all vertices sorted
        Set<Integer> vertices = getAllVertices().stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (Integer vertex : vertices) {
            List<Integer> neighbors = getNeighbors(vertex);
            String edges = neighbors.isEmpty() ? "None"
                    : neighbors.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" → "));
            sb.append(String.format("%3d : %s%n", vertex, edges));
        }

        // Single log statement
        log.info("\n{}", sb.toString());
    }

    @Override
    public Set<Integer> getAllVertices() {
        return Map.copyOf(adj).keySet();
    }
}