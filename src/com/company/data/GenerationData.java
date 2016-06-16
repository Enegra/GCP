package com.company.data;

import com.company.Selector;
import com.company.Specimen;

import java.util.ArrayList;

/**
 * Created by agnie on 6/15/2016.
 */
public class GenerationData {
    private int generationNumber = 0;
    private int maxGenerationNumber;
    private ArrayList<ArrayList<Specimen>> generations;
    private ScoreData scoreData;
    private Specimen bestSpecimen;
    private int bestScore;

    public GenerationData(int maxGenerationNumber) {
        this.maxGenerationNumber = maxGenerationNumber;
        scoreData = new ScoreData();
        generations = new ArrayList<ArrayList<Specimen>>();
        bestSpecimen = null;
    }

    public void saveGenerationData(ArrayList<Specimen> population, ArrayList<Integer> scores) {
        generations.add(population);
        scoreData.rateGeneration(scores);
    }

    public void setBestSpecimen() {
        int bestIndex = scoreData.getAllScores().get(scoreData.getAllScores().size() - 1).indexOf(scoreData.getBestScores().get(scoreData.getBestScores().size() - 1));
        Specimen bestOfGeneration = generations.get(generations.size() - 1).get(bestIndex);
        int score = scoreData.getAllScores().get(scoreData.getAllScores().size() - 1).get(bestIndex);
        if (bestSpecimen == null) {
            bestSpecimen = bestOfGeneration;
            bestScore = score;
        } else {
            if (score < bestScore){
                bestSpecimen = bestOfGeneration;
                bestScore = score;
            }
        }
        System.out.println(bestSpecimen);
        System.out.println(bestScore);
    }

    public int getGenerationNumber() {
        return generationNumber;
    }

    public void nextGeneration() {
        generationNumber++;
    }

    public int getMaxGenerationNumber() {
        return maxGenerationNumber;
    }

    public ArrayList<Integer> getBestScores(){
        return scoreData.getBestScores();
    }
}
