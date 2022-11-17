package com.graphs.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph2 {
    Map<Integer, Vertex> vertexMap = new HashMap<>();

    public Graph2(List<Vertex> vertexList, List<Edge2> edge2List) {
        vertexList.forEach(vertex -> {
            vertexMap.putIfAbsent(vertex.number, vertex);
        });

        edge2List.forEach(edge -> {
                    vertexMap.get(edge.beginning).destination = edge;
                }
        );

        edge2List.forEach(edge -> {
                    vertexMap.get(edge.tail).source = edge;
                }
        );


    }

    public void addEdge(Edge2 edge) {
        vertexMap.get(edge.beginning).destination = edge;
        vertexMap.get(edge.tail).source = edge;
    }

    public void addVertex(Vertex vertex) {
        vertexMap.putIfAbsent(vertex.number, vertex);
    }

    public void deleteVertex(int vertexNumber) {
        Vertex vertex1 = vertexMap.remove(vertexNumber);
        int tail = vertex1.source.tail;
        int beginning = vertex1.destination.beginning;
        Vertex before = vertexMap.get(tail);
        before.destination = null;
        Vertex after = vertexMap.get(beginning);
        after.source = null;
    }

    public void deleteEdge() {

    }
}
