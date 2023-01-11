package com.fsu.edp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The following class holds the information about the vertices
 */
public class Vertex {
    private final long id;
    private final boolean bridge;
    private List<Long> otherHost = new ArrayList<>();
    private final List<Long> bridgeEdge = new ArrayList<>();
    private final List<Edge> edges = new ArrayList<>();

    Vertex(long id, boolean bridge, List<Long> otherHost){
        this.id = id;
        this.bridge = bridge;
        this.otherHost = otherHost;
    }

    public boolean isBridge() {
        return bridge;
    }

    public List<Long> getOtherHost() {
        return otherHost;
    }

    public List<Long> getBridgeEdge() {
        return bridgeEdge;
    }

    public void addBridgeEdge(long distance){
        this.bridgeEdge.add(distance);

    }

    public void addEdge(long distance, long weight) {
        Edge e = new Edge(distance, weight);
        this.edges.add(e);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", bridge=" + bridge +
                ", otherHost=" + otherHost +
                ", bridgeEdge=" + bridgeEdge +
                ", edges=" + edges +
                '}';
    }
}
