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
        for (int i = 0; i < adj.size(); i++) {
            log.info("{} -> {}", i, adj.get(i));
        }
    }

    @Override
    public Set<Integer> getAllVertices() {
        return IntStream.range(0, adj.size())
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
    }
}