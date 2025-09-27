package com.loop.troop.graph;

import com.loop.troop.graph.cycle.CycleDetectionStrategy;
import com.loop.troop.graph.traversal.GraphTraversal;
import lombok.Setter;

import java.util.*;

@Setter
public class GraphManager {

    private GraphTraversal graphTraversalStrategy;
    private CycleDetectionStrategy cycleDetectionStrategy;

    public GraphManager(GraphTraversal graphTraversalStrategy, CycleDetectionStrategy cycleDetectionStrategy) {
        this.graphTraversalStrategy = graphTraversalStrategy;
        this.cycleDetectionStrategy = cycleDetectionStrategy;
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
                List<Integer> compTraversal = graphTraversalStrategy.traverse(graph, vertex, visited);
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
        return  List.copyOf(graphTraversalStrategy.traverse(graph, start, visited));
    }

    public boolean isContainCycle(Graph graph){
        return cycleDetectionStrategy.hasCycle(graph);
    }
}