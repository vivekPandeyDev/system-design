package com.loop.troop.graph;

import java.util.List;
import java.util.Set;

public interface Graph {
    void addEdge(int from, int to);
    void addUndirectedEdge(int v1, int v2);
    List<Integer> getNeighbors(int v);
    void printGraph();
    Set<Integer> getAllVertices();
}