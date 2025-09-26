package com.loop.troop.graph.traversal;

import com.loop.troop.graph.Graph;

import java.util.*;

public class GraphTraversalManager {

    private GraphTraversal strategy;

    public GraphTraversalManager(GraphTraversal strategy) {
        this.strategy = strategy;
    }

    // Traverse all vertices including disconnected components
    public List<Integer> traverseAll(Graph graph) {
        if (Objects.isNull(graph)){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (Integer vertex : graph.getAllVertices()) {
            if (!visited.contains(vertex)) {
                List<Integer> compTraversal = strategy.traverse(graph, vertex, visited);
                result.addAll(compTraversal);
            }
        }

        return List.copyOf(result);
    }

    public List<Integer> traverseFromNode(Graph graph, int start) {
        if (Objects.isNull(graph)){
            return new ArrayList<>();
        }
        Set<Integer> visited = new HashSet<>();
        return  List.copyOf(strategy.traverse(graph, start, visited));
    }

    public void setStrategy(GraphTraversal strategy) {
        if (Objects.nonNull(strategy))
            this.strategy = strategy;
    }
}