package com.company.utils;

/**
 * Created by agnie on 3/12/2016.
 */
public class Edge {
    private int beginNode;
    private int endNode;
    private int weight;

    public Edge(int beginNode, int endNode, int weight) {
        this.beginNode = beginNode;
        this.endNode = endNode;
        this.weight = weight;
    }

    public int getBeginNode() {
        return beginNode;
    }

    public int getEndNode() {
        return endNode;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "Begin node: " + beginNode + ", End node: " + endNode + ", Weight: " + weight;
    }
}
