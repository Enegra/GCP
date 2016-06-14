package com.company;

import com.company.utils.Edge;
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

    public Specimen(Graph graph, int numberOfColours){
        colours = new ArrayList<Integer>(graph.getNumberOfNodes());
        this.numberOfColours=numberOfColours;
        this.numberOfNodes=graph.getNumberOfNodes();
    }

    public Specimen(Graph graph){
        colours = new ArrayList<Integer>(graph.getNumberOfNodes());
        numberOfColours = getNumberOfColours(graph);
        this.numberOfNodes=graph.getNumberOfNodes();
    }

    public void colourSpecimen(){
        for (int i=0; i<numberOfNodes; i++){
            Random random = new Random();
            int colour = random.nextInt(numberOfColours+1);
            colours.add(colour);
        }
    }
    
    private int getNumberOfColours(Graph graph){
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

    public ArrayList<Integer> getColours(){
        return colours;
    }

}
