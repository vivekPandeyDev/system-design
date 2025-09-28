package com.loop.troop.graph.cycle;

import com.loop.troop.graph.Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Detects a cycle in an undirected graph using DFS.
 * Time Complexity: O(V + E)
 * Space Complexity: O(V) recursion stack + visited set.
 */
public final class DfsUndirectedCycleDetection implements CycleDetectionStrategy {

    @Override
    public boolean hasCycle(Graph graph) {
        Set<Integer> visited = new HashSet<>();

        // Handle disconnected components
        for (int vertex : graph.getAllVertices()) {
            if (!visited.contains(vertex) && dfs(graph, vertex, -1, visited)) {
                    return true;
            }

        }
        return false;
    }

    /**
     * @param current current vertex
     * @param parent  parent vertex (so we don’t count the edge we came from)
     */
    private boolean dfs(Graph graph, int current, int parent, Set<Integer> visited) {
        visited.add(current);

        for (int neighbor : graph.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                if (dfs(graph, neighbor, current, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Visited neighbor that is not our parent => cycle
                return true;
            }
        }
        return false;
    }
}
