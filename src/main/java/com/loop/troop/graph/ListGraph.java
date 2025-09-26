package com.loop.troop.graph;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public record ListGraph(List<List<Integer>> adj) implements Graph {

    // Static registration with GraphFactory
    static {
        GraphFactory.register("list", ListGraph::new);
    }

    public ListGraph(int numVertices) {
        this(createAdjacency(numVertices));  // delegate to canonical constructor
    }

    // Helper to build the nested lists
    private static List<List<Integer>> createAdjacency(int size) {
        List<List<Integer>> a = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            a.add(new ArrayList<>());
        }
        return a;
    }

    @Override
    public void addEdge(int from, int to) {
        adj.get(from).add(to);
    }

    @Override
    public void addUndirectedEdge(int v1, int v2) {
        addEdge(v1, v2);
        addEdge(v2, v1);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return adj.get(v);
    }

    @Override
    public void printGraph() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph adjacency list (ListGraph):\n");
        sb.append("---------------------------------\n");

        for (int vertex = 0; vertex < adj.size(); vertex++) {
            List<Integer> neighbors = getNeighbors(vertex);
            String edges = neighbors.isEmpty() ? "None"
                    : neighbors.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" → "));
            sb.append(String.format("%3d : %s%n", vertex, edges));
        }

        // Log the entire graph in a single message
        log.info("\n{}", sb.toString());
    }

    @Override
    public Set<Integer> getAllVertices() {
        return IntStream.range(0, adj.size())
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
    }
}