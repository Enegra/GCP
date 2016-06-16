package com.company.data;


import com.company.utils.ValueFinder;

import java.util.ArrayList;

/**
 * Created by agnie on 6/15/2016.
 */
public class ScoreData {
    private ArrayList<Double> scores;

    private ArrayList<Integer> bestScores = new ArrayList<Integer>();
    private ArrayList<Integer> worstScores = new ArrayList<Integer>();
    private ArrayList<Integer> averageScores = new ArrayList<Integer>();
    private ArrayList<ArrayList<Integer>> allScores = new ArrayList<ArrayList<Integer>>();


    private int getBest(ArrayList<Integer> scores){
        return ValueFinder.findMinimum(scores);
    }

    private int getWorst(ArrayList<Integer> scores){
        return ValueFinder.findMaximum(scores);
    }

    private int getAverage(ArrayList<Integer> scores){
        return ValueFinder.findArithmeticAverage(scores);
    }

    public void rateGeneration(ArrayList<Integer> scores){
        allScores.add(scores);
        bestScores.add(getBest(scores));
        worstScores.add(getWorst(scores));
        averageScores.add(getAverage(scores));
    }

    public ArrayList<Integer> getBestScores(){
        return bestScores;
    }

    public ArrayList<Integer> getWorstScores(){
        return worstScores;
    }

    public ArrayList<Integer> getAverageScores(){
        return averageScores;
    }

    public ArrayList<ArrayList<Integer>> getAllScores(){
        return allScores;
    }
}