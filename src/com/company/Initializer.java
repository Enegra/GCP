package com.company;

import java.util.ArrayList;

/**
 * Created by agnie on 3/23/2016.
 */
public class Initializer {

    public ArrayList<Specimen> initialize(int populationSize, Graph graph){
        ArrayList<Specimen> population = new ArrayList<Specimen>(populationSize);
        for (int i=0; i<populationSize; i++){
            population.add(new Specimen(graph));
        }
        return population;
    }

    public ArrayList<Specimen> initialize(int populationSize, Graph graph, int numberOfColours){
        ArrayList<Specimen> population = new ArrayList<Specimen>(populationSize);
        for (int i=0; i<populationSize; i++){
            population.add(new Specimen(graph, numberOfColours));
        }
        return population;
    }

}
