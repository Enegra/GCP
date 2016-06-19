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
            int errorCount = 0;
            for (int i = 0; i < specimen.getSize(); i++) {
                ArrayList<Edge> edges = specimen.getEdges(i);
                if (edges != null) {
                    for (Edge edge : edges) {
                        int nodeColour = specimen.getColour(i);
                        int neighbourColour = specimen.getColour(specimen.indexOf(specimen.findNode(edge.getEndNode())));
                        if (Math.abs(nodeColour - neighbourColour) < edge.getWeight()) {
                            errorCount = errorCount + (edge.getWeight() - Math.abs(nodeColour - neighbourColour));
                        }
                    }
                }
            }
            scores.add(errorCount);
        }
        return scores;
    }


}
