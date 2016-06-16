package com.company;

import com.company.data.GenerationData;
import com.company.data.ScoreData;

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
        if (currentGenerationNumber >= numberOfScoresChecked) {
            for (int i = currentGenerationNumber - numberOfScoresChecked; i < currentGenerationNumber-1; i++) {
                if (generationData.getBestScores().get(i) < generationData.getBestScores().get(i + 1)) {
                    System.out.println(generationData.getBestScores().get(i) + " " + generationData.getBestScores().get(i + 1));
                    return true;
                }
            }
        }
        return false;
    }

}
