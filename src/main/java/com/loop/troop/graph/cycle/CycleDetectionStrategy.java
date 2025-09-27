package com.loop.troop.graph.cycle;

import com.loop.troop.graph.Graph;

public interface CycleDetectionStrategy {
    boolean hasCycle(Graph graph);
}
