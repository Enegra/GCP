package com.company;

import com.company.utils.Edge;
import com.company.utils.Node;
import com.company.utils.ValueFinder;

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

    public Specimen(Graph graph, int numberOfColours){
        this.graph=graph;
        this.numberOfColours=numberOfColours;
        numberOfNodes=graph.getNumberOfNodes();
        colours = new ArrayList<Integer>(graph.getNumberOfNodes());
        colourSpecimen();
    }

    public Specimen(Graph graph){
        this.graph=graph;
        numberOfColours = getNumberOfColours();
        numberOfNodes=graph.getNumberOfNodes();
        colours = new ArrayList<Integer>(graph.getNumberOfNodes());
        colourSpecimen();
    }

    public Specimen(Specimen parentOne, Specimen parentTwo){
        this.graph = parentOne.graph;
        this.numberOfColours = parentOne.numberOfColours;
        this.numberOfNodes = parentOne.numberOfNodes;
        colours = new ArrayList<Integer>(numberOfNodes);
        for (int i=0; i<numberOfNodes/2; i++){
            this.colours.add(parentOne.getColour(i));
        }
        for (int i=numberOfNodes/2; i<numberOfNodes; i++){
            this.colours.add(parentTwo.getColour(i));
        }
    }

    public void colourSpecimen(){
        for (int i=0; i<numberOfNodes; i++){
            Random random = new Random();
            int colour = random.nextInt(numberOfColours+1);
            colours.add(colour);
        }
    }
    
    private int getNumberOfColours(){
        ArrayList<Integer> edgeWeights = new ArrayList<Integer>();
        for (Edge edge : graph.getEdges()){
            edgeWeights.add(edge.getWeight());
        }
        return ValueFinder.findMaximum(edgeWeights)+1;
    }

    public void setColour(int index, int colour){
        colours.set(index, colour);
    }

    public int getColour(int index){
        return colours.get(index);
    }

    public Node getNode(int index)
    {
        return graph.getNodes().get(index);
    }

    public Node findNode(int indexValue){
        for (Node node : graph.getNodes()){
            if (node.getNodeIndex() == indexValue){
                return node;
            }
        }
        return null;
    }

    public int indexOf(Node node){
        return graph.getNodes().indexOf(node);
    }

    public ArrayList<Edge> getEdges(Node node){
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (Edge edge : graph.getEdges())
        if (node.getNodeIndex()==edge.getBeginNode()){
            edges.add(edge);
        }
        return edges;
    }

    public ArrayList<Edge> getEdges(int index){
        return getEdges(getNode(index));
    }

    public int getSize(){
        return numberOfNodes;
    }

    public ArrayList<Integer> getColours(){
        return colours;
    }

    @Override
    public String toString(){
        return String.valueOf(colours);
    }

}
