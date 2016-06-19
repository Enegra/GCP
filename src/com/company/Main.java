package com.company;

import com.company.data.GenerationData;
import com.company.utils.ScoreChart;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        int maxGenerationNumber = 100;
        int generationsChecked = 10;
        int populationSize = 50;
        int tournamentSize = 3;
        double crossingProbability = 0.8;
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

        while (!stopper.stopCondition()) {
            scores = evaluator.evaluate(population);
            generationData.saveGenerationData(population, scores);
            population = selector.select(population, scores);
            crosser.cross(population, populationSize, crossingProbability);
            mutator.mutate(population, mutationProbability);
            generationData.setBestSpecimen();
            generationData.nextGeneration();

        }

        ScoreChart scoreChart = new ScoreChart(generationData.getScoreData());
        System.out.println(generationData.getBestSpecimen());


    }
}
