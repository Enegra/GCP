package com.company;

import com.company.utils.Edge;

import java.util.ArrayList;

/**
 * Created by agnie on 6/14/2016.
 */
public class Evaluator {

    public ArrayList<Integer> evaluate(ArrayList<Specimen> population) {
        ArrayList<Integer> scores = new ArrayList<Integer>(population.size());
        for (Specimen specimen : population) {
            scores.add(evaluate(specimen));
        }
        return scores;
    }

    public int evaluate(Specimen specimen){
        int errorCount = 0;
        for (int i = 0; i < specimen.getSize(); i++) {
            ArrayList<Edge> edges = specimen.getEdges(i);
//                System.out.println("Node edges: " + edges);
            if (edges != null) {
                for (Edge edge : edges) {
                    if (edge.getBeginNode()!=edge.getEndNode()){
                        int nodeColour = specimen.getColour(i);
                        int neighbourColour = specimen.getColour(specimen.indexOf(specimen.findNode(edge.getEndNode())));
                        if (Math.abs(nodeColour - neighbourColour) < edge.getWeight()) {
                            errorCount = errorCount + (edge.getWeight() - Math.abs(nodeColour - neighbourColour));
                        }
                    }
                }
            }
        }
        return errorCount;
    }


}
