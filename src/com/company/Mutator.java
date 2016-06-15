package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by agnie on 6/14/2016.
 */
public class Mutator {

    public void mutate(ArrayList<Specimen> population, double mutationProbability){
        for (Specimen specimen : population){
            for (int i=0; i<specimen.getSize(); i++){
                Random random = new Random();
                if (random.nextDouble()<=mutationProbability){
                    specimen.alterColour(i);
                }
            }
        }
    }

}
