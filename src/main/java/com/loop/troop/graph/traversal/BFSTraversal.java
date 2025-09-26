package com.loop.troop.graph.traversal;

import com.loop.troop.graph.Graph;

import java.util.*;

public class BFSTraversal implements GraphTraversal {

    @Override
    public List<Integer> traverse(Graph graph, int start, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.getNeighbors(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }
}
