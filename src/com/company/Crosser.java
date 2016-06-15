package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by agnie on 6/14/2016.
 */
public class Crosser {

    public void cross(ArrayList<Specimen> population, int desiredPopulationSize, double crossingProbability){
        Random random = new Random();
        while (population.size() < desiredPopulationSize){
            int parentOne = random.nextInt(population.size());
            int parentTwo = random.nextInt(population.size());
            if (random.nextDouble() <= crossingProbability) {
                Specimen newSpecimen = new Specimen(population.get(parentOne), population.get(parentTwo));
                //// TODO: 6/14/2016 dodać losowe czerpanie genów
                population.add(newSpecimen);
            }
        }
    }

}
