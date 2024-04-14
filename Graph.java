package org.example;

import java.util.*;

public class Graph<T> {

    private final List<Edge<T>> allEdges;
    private final Map<Long, Vertex<T>> allVertex;
    boolean isDirected ;

    public Graph(boolean isDirected) {
        allEdges = new ArrayList<>();
        allVertex = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }

    public Vertex<T> getVertex(long id) {
        return allVertex.get(id);
    }

    public void addEdge(long id1, long id2, int weight) {
        Vertex<T> vertex1;
        if (allVertex.containsKey(id1)) {
            vertex1 = allVertex.get(id1);
        } else {
            vertex1 = new Vertex<>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2;
        if (allVertex.containsKey(id2)) {
            vertex2 = allVertex.get(id2);
        } else {
            vertex2 = new Vertex<>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<>(vertex1, vertex2, isDirected, weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if (!isDirected) {
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }
    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex() {
        return allVertex.values();
    }
}
