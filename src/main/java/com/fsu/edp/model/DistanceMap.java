package com.fsu.edp.model;

import java.util.Objects;

/**
 * Key hashing used for revers lookup
 */
public class DistanceMap {
    Long label;
    Long dst;

    private final int hashCode;

    public DistanceMap(Long label, Long dst) {
        this.label = label;
        this.dst = dst;
        this.hashCode = Objects.hash(label, dst);
    }

    @Override
    public String toString() {
        return "DistanceMap{" +
                "label=" + label +
                ", dst=" + dst +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DistanceMap that = (DistanceMap) o;
        return Objects.equals(label, that.label) && Objects.equals(dst, that.dst);
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
