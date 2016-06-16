package com.company;

import com.company.data.GenerationData;
import com.company.utils.FilePicker;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        int maxGenerationNumber = 50;
        int generationsChecked = 5;
        int populationSize = 20;
        double crossingProbability = 0.7;
        double mutationProbability = 0.1;

        GenerationData generationData = new GenerationData(maxGenerationNumber);

        Initializer initializer = new Initializer();
        ArrayList<Specimen> population = initializer.initialize(populationSize);
        System.out.println("Initialized population of size: " + population.size());
        System.out.println(population);

        Evaluator evaluator = new Evaluator();
        ArrayList<Integer> scores = evaluator.evaluate(population);
        System.out.println(scores);

        generationData.saveGenerationData(population,scores);

        Selector selector = new Selector();
        population = selector.select(population, scores, 3);
        System.out.println(population);

        Crosser crosser = new Crosser();
        crosser.cross(population, populationSize, crossingProbability);
        System.out.println(population);

        Mutator mutator = new Mutator();
        mutator.mutate(population, mutationProbability);
        System.out.println(population);


        generationData.setBestSpecimen();

    }
}
