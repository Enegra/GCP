package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by agnie on 6/14/2016.
 */
public class Crosser {

    public void cross(ArrayList<Specimen> population, int desiredPopulationSize, double crossingProbability){
        while (population.size() < desiredPopulationSize){
            Random random = new Random();
            int parentOne = random.nextInt(population.size());
            int parentTwo = random.nextInt(population.size());
            double coinToss = random.nextDouble();
            if (coinToss <= crossingProbability) {
                Specimen newSpecimen = new Specimen(population.get(parentOne), population.get(parentTwo));
                //// TODO: 6/14/2016 dodać losowe czerpanie genów
                population.add(newSpecimen);
            }
        }
    }

}
