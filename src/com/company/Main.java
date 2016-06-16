package com.company;

import com.company.utils.FilePicker;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        int maxGenerationNumber = 50;
        int generationsChecked = 10;
        int populationSize = 40;
        int tournamentSize = 3;
        double crossingProbability = 0.7;
        double mutationProbability = 0.2;

        ArrayList<Specimen> population;
        ArrayList<Integer> scores;


        Graph graph = new Graph();
        FilePicker filePicker = new FilePicker();
        graph.readGraph(filePicker.getFilePath());

//        GenerationData generationData = new GenerationData(maxGenerationNumber);
//        Initializer initializer = new Initializer();
//        Evaluator evaluator = new Evaluator();
//        Selector selector = new Selector();
//        Crosser crosser = new Crosser();
//        Mutator mutator = new Mutator();
//        Stopper stopper = new Stopper(generationData, generationsChecked);

//        population = initializer.initialize(populationSize);

//        while (!stopper.stopCondition()){
//            scores = evaluator.evaluate(population);
//            generationData.saveGenerationData(population,scores);
//            population = selector.select(population, scores, tournamentSize);
//            crosser.cross(population, populationSize, crossingProbability);
//            mutator.mutate(population, mutationProbability);
//            generationData.setBestSpecimen();
//            generationData.nextGeneration();
//
//        }


    }
}
