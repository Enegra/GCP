package com.company;

import com.company.utils.FilePicker;

import java.util.ArrayList;

/**
 * Created by agnie on 3/23/2016.
 */
public class Initializer {

    private Graph graph;

    public Initializer() {
        graph = new Graph();
        FilePicker filePicker = new FilePicker();
        graph.readGraph(filePicker.getFilePath());
//        System.out.println("Graph loaded");
    }

    public ArrayList<Specimen> initialize(int populationSize) {
        ArrayList<Specimen> population = new ArrayList<Specimen>(populationSize);
        for (int i = 0; i < populationSize; i++) {
            population.add(new Specimen(graph, 25));
        }
        return population;
    }

    public ArrayList<Specimen> initialize(int populationSize, int numberOfColours) {
        ArrayList<Specimen> population = new ArrayList<Specimen>(populationSize);
        for (int i = 0; i < populationSize; i++) {
            population.add(new Specimen(graph, numberOfColours));
        }
        return population;
    }

}
