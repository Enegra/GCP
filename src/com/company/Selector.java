package com.company;

import com.company.utils.ValueFinder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by agnie on 6/14/2016.
 */
public class Selector {

    public ArrayList<Specimen> select(ArrayList<Specimen> population, ArrayList<Integer> scores, int tournamentSize) {
        ArrayList<Specimen> newPopulation = new ArrayList<Specimen>(population.size() / 2);
        for (int i = 0; i < population.size() / 2; i++) {
            newPopulation.add(tournamentSelect(population, scores, tournamentSize));
        }
        return newPopulation;
    }

    private Specimen tournamentSelect(ArrayList<Specimen> population, ArrayList<Integer> scores, int tournamentSize) {
        ArrayList<Specimen> pool = new ArrayList<Specimen>(tournamentSize);
        ArrayList<Integer> tournamentScores = new ArrayList<Integer>(tournamentSize);
        Random random = new Random();
        for (int i = 0; i < tournamentSize; i++) {
            int randomIndex = random.nextInt(population.size());
            pool.add(population.get(randomIndex));
            tournamentScores.add(scores.get(randomIndex));
        }
        int bestIndex = ValueFinder.findMinimum(tournamentScores);
        return pool.get(tournamentScores.indexOf(bestIndex));
    }

    public ArrayList<Specimen> select(ArrayList<Specimen> population, ArrayList<Integer> scores) {
        int maxErrorCount = ValueFinder.findMaximum(scores);
        ArrayList<Specimen> rouletteWheel = new ArrayList<Specimen>();
        for (int i=0; i<population.size(); i++){
            int difference = maxErrorCount - scores.get(i);
            for (int j=0; j<difference; j++){
                rouletteWheel.add(population.get(i));
            }
        }
        ArrayList<Specimen> newPopulation = new ArrayList<Specimen>(population.size() / 2);
        Random random = new Random();
        for (int i = 0; i < population.size() / 2; i++) {
            int roulettePointer = random.nextInt(rouletteWheel.size());
            newPopulation.add(rouletteWheel.get(i));
        }
        return newPopulation;
    }

}


