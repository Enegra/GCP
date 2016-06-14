package com.company.utils;

import java.util.ArrayList;

/**
 * Created by agnie on 6/13/2016.
 */
public class ValueFinder {

    public static int findMaximum(ArrayList<Integer> list) {
        int maximum = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > maximum) {
                maximum = list.get(i);
            }
        }
        return maximum;
    }

    public static int findMinimum(ArrayList<Integer> list) {
        int minimum = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < minimum) {
                minimum = list.get(i);
            }
        }
        return minimum;
    }

    public static int findArithmeticAverage(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        int average = sum / list.size();
        return average;
    }

}
