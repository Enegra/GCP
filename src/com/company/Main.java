package com.company;

import com.company.utils.FilePicker;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        Initializer initializer = new Initializer();
        ArrayList<Specimen> population = initializer.initialize(30);
        System.out.println("Initialized population of size: " + population.size());
        System.out.println(population);

    }
}
