package com.fsu.edp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Holds all the labels with its respective ID
 */
public class Index {

    private final Map<Long, Partition> partitions = new HashMap<>();

    public Partition getPartition(Long label){
        return partitions.get(label);
    }
    public List<Long> getOtherHosts(Long label, Long vertexId){
        return partitions.get(label).getVertex(vertexId).getOtherHost();
    }
    public Long getMinPr(Long src, Set<Long> labels){
        //TO-DO
        long min = Long.MAX_VALUE;
        long label = Long.MAX_VALUE;
        for (Long key: partitions.keySet()) {
            Partition val = partitions.get(key);
            if(val.contains(src) && labels.contains(key)){
                for(Edge edgeKey: val.getEdge(src)){
                    if(edgeKey.getWeight() < min){
                        min = edgeKey.getWeight();
                        label = key;
                    }

                }

            }

        }
        return label;
    }
    public boolean isBridge(Long label, Long vertexId) {
        return partitions.get(label).getVertex(vertexId).isBridge();
    }
    public void createPartition(Long label){
        partitions.put(label, new Partition());
    }
    public Long getCost(Long label, Long src, Long dst){
        return partitions.get(label).getCost(src, dst);
    }
    public boolean containsCost(Long label, Long src, Long dst){
        return partitions.get(label).containsCost(src, dst);
    }
    public List<Long> getBridgeEdges(long label, long vertexId){
        return partitions.get(label).getVertex(vertexId).getBridgeEdge();
    }

    @Override
    public String toString() {
        return "Index{" +
                "partitions=" + partitions +
                '}';
    }
}
