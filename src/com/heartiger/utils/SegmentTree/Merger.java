package com.heartiger.utils.SegmentTree;

public interface Merger<T> {
    T merge(T a, T b);
}