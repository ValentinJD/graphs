package com.graphs.libraries.simple;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SimpleMain {
    public static void main(String[] args) {
        Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
        g.addVertex("v1");
        g.addVertex("v2");
        g.addEdge("v1", "v2");


        DirectedGraph<String, DefaultEdge> directedGraph
                = new DefaultDirectedGraph<>(DefaultEdge.class);
        directedGraph.addVertex("v1");
        directedGraph.addVertex("v2");
        directedGraph.addVertex("v3");
        DefaultWeightedEdge edge1 = (DefaultWeightedEdge) directedGraph.addEdge("v1", "v2");


        DepthFirstIterator depthFirstIterator
                = new DepthFirstIterator<>(directedGraph);
        BreadthFirstIterator breadthFirstIterator
                = new BreadthFirstIterator<>(directedGraph);


    }

    public Multigraph createMultiGraphWithWeightedEdges() {
        Multigraph multiGraph = new Multigraph<>(DefaultWeightedEdge.class);
        multiGraph.addVertex("v1");
        multiGraph.addVertex("v2");
        multiGraph.addVertex("v3");
        DefaultWeightedEdge edge1 = (DefaultWeightedEdge) multiGraph.addEdge("v1", "v2");
        multiGraph.setEdgeWeight(edge1, 2);

        DefaultWeightedEdge edge2 = (DefaultWeightedEdge) multiGraph.addEdge("v2", "v3");
        multiGraph.setEdgeWeight(edge2, 3);

        DefaultWeightedEdge edge3 = (DefaultWeightedEdge) multiGraph.addEdge("v1", "v3");
        multiGraph.setEdgeWeight(edge3, 1);


        return multiGraph;
    }

    @Test
    public void whenGetDijkstraShortestPath_thenGetNotNullPath() {
        DijkstraShortestPath dijkstraShortestPath
                = new DijkstraShortestPath(createMultiGraphWithWeightedEdges());
        List<String> shortestPath = dijkstraShortestPath.getPath("v1", "v3").getVertexList();

        assertNotNull(shortestPath);
    }
}
