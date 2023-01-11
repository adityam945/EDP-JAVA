package com.fsu.edp.model;

/**
 * Queuing system used for Dijkstra algorithm.
 */
public class PQElement {
    Long label;
    Long dst;
    Long cost;

    public PQElement(Long label, Long dst, Long cost){
        this.label = label;
        this.dst = dst;
        this.cost = cost;
    }

    public Long getLabel() {
        return label;
    }

    public Long getDst() {
        return dst;
    }

    public Long getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "PQElement{" +
                "label=" + label +
                ", dst=" + dst +
                ", cost=" + cost +
                '}';
    }
}
