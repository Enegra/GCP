package com.company;

import com.company.data.GenerationData;
import com.company.utils.FilePicker;

import java.util.ArrayList;


public class Main {

    private static Graph prepareGraph(){
        Graph graph = new Graph();
        FilePicker filePicker = new FilePicker();
        graph.readGraph(filePicker.getFilePath());
        return graph;
    }

    public static void main(String[] args) {

        int maxGenerationNumber = 1000;
        int generationsChecked = 20;
        int populationSize = 50;
        int tournamentSize = 6;
        double crossingProbability = 0.7;
        double mutationProbability = 0.2;

        ArrayList<Specimen> population;
        ArrayList<Integer> scores;

        Graph graph = prepareGraph();

        GenerationData generationData = new GenerationData(maxGenerationNumber);
        Initializer initializer = new Initializer(graph);
        Evaluator evaluator = new Evaluator();
        Selector selector = new Selector();
        Crosser crosser = new Crosser();
        Mutator mutator = new Mutator();
        Stopper stopper = new Stopper(generationData, generationsChecked);

//        population = initializer.initialize(populationSize, 22);
//
//        while (!stopper.stopCondition()) {
//            scores = evaluator.evaluate(population);
//            generationData.saveGenerationData(population, scores);
//            generationData.setBestSpecimen();
//            population = selector.select(population, scores, tournamentSize);
//            crosser.cross(population, populationSize, crossingProbability);
//            mutator.mutate(population, mutationProbability);
//            generationData.nextGeneration();
//        }
//
//        ScoreChart scoreChart = new ScoreChart(generationData.getScoreData());
//        System.out.println(generationData.getBestSpecimen());

        ForceSolver forceSolver = new ForceSolver(graph, 10000000, 22);
        forceSolver.solve();
        System.out.println(forceSolver.getSolution());
        System.out.println(forceSolver.getCurrentAttempt());
        System.out.println(forceSolver.getScore());


    }
}
