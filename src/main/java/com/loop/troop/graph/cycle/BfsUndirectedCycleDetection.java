package com.loop.troop.graph.cycle;

import com.loop.troop.graph.Graph;

import java.util.*;

public final class BfsUndirectedCycleDetection implements CycleDetectionStrategy {

    @Override
    public boolean hasCycle(Graph graph) {
        Set<Integer> visited = new HashSet<>();

        for (int start : graph.getAllVertices()) {
            if (!visited.contains(start) && bfs(graph, start, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean bfs(Graph graph, int start, Set<Integer> visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1});
        visited.add(start);

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbor : graph.getNeighbors(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // found back-edge
                }
            }
        }
        return false;
    }
}
