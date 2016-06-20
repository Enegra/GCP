package com.company;

import com.company.utils.Edge;
import com.company.utils.Node;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by agnie on 6/13/2016.
 */
public class Specimen {

    private ArrayList<Integer> colours;
    private int numberOfColours;
    private int numberOfNodes;
    private Graph graph;
    private int maxEdgeWeight;
    private int edgeDensity;

    public Specimen(Graph graph, int numberOfColours) {
        this.graph = graph;
        this.numberOfColours = numberOfColours;
        this.numberOfNodes = graph.getNumberOfNodes();
        colours = new ArrayList<Integer>(graph.getNumberOfNodes());
        colourSpecimen();
    }

    public Specimen(Graph graph) {
        this.graph = graph;
        numberOfNodes = graph.getNumberOfNodes();
        maxEdgeWeight = graph.getMaxEdgeWeight();
        edgeDensity = graph.getEdgeDensity();
        numberOfColours = getNumberOfColours();
        colours = new ArrayList<Integer>(graph.getNumberOfNodes());
        colourSpecimen();
    }

    public Specimen(Specimen parentOne, Specimen parentTwo) {
        this.graph = parentOne.graph;
        this.numberOfColours = parentOne.numberOfColours;
        this.numberOfNodes = parentOne.numberOfNodes;
        colours = new ArrayList<Integer>(numberOfNodes);
        Random random = new Random();
        double percentage = random.nextDouble();
        int threshold = (int) (percentage * numberOfNodes);
        for (int i = 0; i < threshold; i++) {
            this.colours.add(parentOne.getColour(i));
        }
        for (int i = threshold; i < numberOfNodes; i++) {
            this.colours.add(parentTwo.getColour(i));
        }
    }

    public void colourSpecimen() {
        if (colours!=null){
            colours.clear();
        }
        for (int i = 0; i < numberOfNodes; i++) {
            Random random = new Random();
            int colour = random.nextInt(numberOfColours + 1);
            colours.add(colour);
        }
    }


    private int getNumberOfColours() {
        return Math.max(maxEdgeWeight + 1, edgeDensity*maxEdgeWeight/2);
    }

    public void setColour(int index, int colour) {
        colours.set(index, colour);
    }

    public void alterColour(int index) {
        Random random = new Random();
        int colour = random.nextInt(numberOfColours + 1);
        setColour(index, colour);
    }

    public int getColour(int index) {
        return colours.get(index);
    }

    public Node getNode(int index) {
        return graph.getNodes().get(index);
    }

    public Node findNode(int indexValue) {
        for (Node node : graph.getNodes()) {
            if (node.getNodeIndex() == indexValue) {
                return node;
            }
        }
        return null;
    }

    public int indexOf(Node node) {
        return graph.getNodes().indexOf(node);
    }

    public int getSize() {
        return numberOfNodes;
    }

    public ArrayList<Integer> getColours() {
        return colours;
    }

    @Override
    public String toString() {
        return String.valueOf(colours);
    }

    public ArrayList<Edge> getEdges(int index) {
        return graph.getEdges(index);
    }

}
