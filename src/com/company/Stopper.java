package com.company;

import com.company.data.GenerationData;

/**
 * Created by agnie on 6/16/2016.
 */
public class Stopper {

    private GenerationData generationData;
    private int numberOfScoresChecked;

    public Stopper(GenerationData generationData, int numberOfScoresChecked) {
        this.generationData = generationData;
        this.numberOfScoresChecked = numberOfScoresChecked;
    }

    public boolean stopCondition() {
        int currentGenerationNumber = generationData.getGenerationNumber();
        int maxGenerationNumber = generationData.getMaxGenerationNumber();
        if (currentGenerationNumber >= maxGenerationNumber) {
            return true;
        }
        if (currentGenerationNumber>0 && generationData.getBestScore()==0){
            return true;
        }
        if (currentGenerationNumber >= numberOfScoresChecked) {
            boolean isNotImproving = true;
//            System.out.println("Current generation: " + currentGenerationNumber);
            for (int i = currentGenerationNumber - numberOfScoresChecked; i < currentGenerationNumber - 1; i++) {
                if (generationData.getBestScores().get(i + 1) <= generationData.getBestScores().get(i)) {
//                if (generationData.getBestScores().get(i) <= generationData.getHistoricalBestScores().get(currentGenerationNumber - numberOfScoresChecked)){
                    isNotImproving = false;
                }
            }
            return isNotImproving;
        }
        return false;
    }

}
