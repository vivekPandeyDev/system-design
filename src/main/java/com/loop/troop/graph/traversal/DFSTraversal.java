package com.loop.troop.graph.traversal;

import com.loop.troop.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DFSTraversal implements GraphTraversal {

    @Override
    public List<Integer> traverse(Graph graph, int start, Set<Integer> visited) {
        List<Integer> result = new ArrayList<>();
        dfsHelper(graph, start, visited, result);
        return result;
    }

    private void dfsHelper(Graph graph, int node, Set<Integer> visited, List<Integer> result) {
        visited.add(node);
        result.add(node);

        for (int neighbor : graph.getNeighbors(node)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(graph, neighbor, visited, result);
            }
        }
    }
}