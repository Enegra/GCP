package com.company;

import com.company.data.GenerationData;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        int maxGenerationNumber = 1000;
        int generationsChecked = 50;
        int populationSize = 100;
        int tournamentSize = 2;
        double crossingProbability = 0.7;
        double mutationProbability = 0.3;

        ArrayList<Specimen> population;
        ArrayList<Integer> scores;

        GenerationData generationData = new GenerationData(maxGenerationNumber);
        Initializer initializer = new Initializer();
        Evaluator evaluator = new Evaluator();
        Selector selector = new Selector();
        Crosser crosser = new Crosser();
        Mutator mutator = new Mutator();
        Stopper stopper = new Stopper(generationData, generationsChecked);

        population = initializer.initialize(populationSize);

        while (!stopper.stopCondition()){
            scores = evaluator.evaluate(population);
            generationData.saveGenerationData(population,scores);
            population = selector.select(population, scores, tournamentSize);
            crosser.cross(population, populationSize, crossingProbability);
            mutator.mutate(population, mutationProbability);
            generationData.setBestSpecimen();
            generationData.nextGeneration();

        }


    }
}
