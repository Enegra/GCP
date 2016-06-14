package com.company;

import com.company.utils.FilePicker;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        Initializer initializer = new Initializer();
        ArrayList<Specimen> population = initializer.initialize(30);
        System.out.println("Initialized population of size: " + population.size());
        System.out.println(population);
        Evaluator evaluator = new Evaluator();
        ArrayList<Integer> scores = evaluator.evaluate(population);
        System.out.println(scores);
        Selector selector = new Selector();
        population = selector.select(population, scores, 3);
        System.out.println(population);
        Crosser crosser = new Crosser();
        crosser.cross(population, 30, 0.7);
        System.out.println(population);

    }
}
