package com.loop.troop.graph.traversal;

import com.loop.troop.graph.Graph;

import java.util.List;
import java.util.Set;

public interface GraphTraversal {
    List<Integer> traverse(Graph graph, int start, Set<Integer> visited);
}
