package com.company.utils;

/**
 * Created by agnie on 3/12/2016.
 */
public class Node {

    private int nodeIndex;
    private int nodeWeight;
    private int colour;

    public Node(int nodeIndex, int nodeWeight){
        this.nodeIndex=nodeIndex;
        this.nodeWeight=nodeWeight;
    }

    public int getNodeIndex(){
        return nodeIndex;
    }

    public int getNodeWeight(){
        return nodeWeight;
    }

    public int getColour(){
        return colour;
    }

    public void setColour(int colour){
        this.colour=colour;
    }

    @Override
    public String toString(){
        return "Node index: " + nodeIndex + ", Node weight: " + nodeWeight;
    }
}
