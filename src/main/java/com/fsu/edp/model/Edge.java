package com.fsu.edp.model;

/**
 * Holds the Edge of a vertex. Forever vertex it contains an edge to a difference vertex with its respective weights.
 */
public class Edge {
    Long dst;
    Long weight;

    public Edge(Long dst, Long weight){
        this.dst = dst;
        this.weight = weight;
    }

    public long getWeight() {
        return weight;
    }

    public long getDst() {
        return dst;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "dst=" + dst +
                ", weight=" + weight +
                '}';
    }
}
