package com.fsu.edp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For every partition the exits it holds the respective nodes and the cost between multiple vertices.
 */
public class Partition {
    private final Map<Long, Vertex> vertices = new HashMap<>();
    private final Map<Long, Map<Long, Long>> cost = new HashMap<>();

    public boolean contains(Long vertex_id){
        return vertices.containsKey(vertex_id);
    }
    public void addVertex(Long id, boolean isBridge, List<Long> otherHosts){
        Vertex vertex = new Vertex(id, isBridge, otherHosts);
        vertices.put(id, vertex);
    }
    public void addEdge(Long src, Long dst, Long weight){
        vertices.get(src).addEdge(dst, weight);
    }

    public boolean isBridge(Long vertexId){
        if(vertices.containsKey(vertexId)){
            return vertices.get(vertexId).isBridge();
        }else{
            return false;
        }

    }

    public Vertex getVertex(Long vertexId){
        return vertices.get(vertexId);
    }
    public List<Edge> getEdge(Long vertexId){
        return vertices.get(vertexId).getEdges();
    }
    public boolean containsCost(Long src, Long dst){
        if(cost.containsKey(src)){
            return cost.get(src).containsKey(dst);
        }else{
            return false;
        }

    }

    public void addCost(Long src, Long dst, Long distance){
        Map<Long,Long> disCost;
        if(!cost.containsKey(src)){
            disCost= new HashMap<>();
        }else{
            disCost = cost.get(src);
        }
        disCost.put(dst, distance);
        cost.put(src, disCost);
    }
    public Long getCost(Long src, Long dst){
        return cost.get(src).get(dst);
    }
    public long getCostSize(){
        return cost.size();
    }

    @Override
    public String toString() {
        return "Partation{" +
                "vertices=" + vertices +
                ", cost=" + cost +
                '}';
    }
}
