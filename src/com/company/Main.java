package com.company;

import com.company.utils.FilePicker;



public class Main {

    public static void main(String[] args){

        Graph graph = new Graph();
        FilePicker filePicker = new FilePicker();
        graph.readGraph(filePicker.getFilePath());
        System.out.println("Graph loaded");

    }
}
