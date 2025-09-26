package com.loop.troop.graph;

import com.loop.troop.graph.traversal.BFSTraversal;
import com.loop.troop.graph.traversal.DFSTraversal;
import com.loop.troop.graph.traversal.GraphTraversal;
import com.loop.troop.graph.traversal.GraphTraversalManager;
import lombok.extern.log4j.Log4j2;

import java.util.stream.IntStream;

@Log4j2
public class GraphDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.loop.troop.graph.MapGraph");
        Class.forName("com.loop.troop.graph.ListGraph");
        int vertex =5;
        Graph g1 = GraphFactory.create("map",0);
        Graph g2 = GraphFactory.create("list",vertex);

        useGraph("MapGraph",vertex, g1);
        log.info("------");
        useGraph("ListGraph",vertex, g2);

        // Example of dynamic vertex addition when supported
        if (g1 instanceof MutableGraph mg) {
            mg.addVertex(99);
            mg.addEdge(2, 99);
            mg.addEdge(99,100);
            log.info("After adding vertex 99:");
            mg.printGraph();
        }

        GraphTraversal bfs = new BFSTraversal();
        GraphTraversal dfs = new DFSTraversal();
        GraphTraversalManager manager = new GraphTraversalManager(bfs);
        log.info("BFS: {}" , manager.traverseFromNode(g1,0 ));
        manager.setStrategy(dfs);
        log.info("DFS: {}" , manager.traverseAll(g2 ));
    }

    private static void useGraph(String name,int vertex, Graph g) {
        log.info("Using {}", name);
        // For MutableGraph we can add vertices first
        if (g instanceof MutableGraph mg) {
            IntStream.range(0,vertex).forEach(mg::addVertex);
        }
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(1, 2);
        g.addUndirectedEdge(2, 3);
        g.printGraph();
    }
}