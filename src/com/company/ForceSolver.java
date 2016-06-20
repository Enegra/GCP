package com.company;

/**
 * Created by agnie on 6/20/2016.
 */
public class ForceSolver {

    private int maxAttempts;
    private Graph graph;
    private Specimen specimen;
    private Evaluator evaluator=new Evaluator();
    private int score;
    private int currentAttempt;

    public ForceSolver(Graph graph, int maxAttempts){
        this.maxAttempts = maxAttempts;
        this.graph=graph;
        specimen = new Specimen(graph);
    }

    public ForceSolver(Graph graph, int maxAttempts, int numberOfColours){
        this.maxAttempts = maxAttempts;
        this.graph=graph;
        specimen = new Specimen(graph, numberOfColours);
    }


    public void solve(){
        while (!stopCondition()){
            specimen.colourSpecimen();
            score = evaluator.evaluate(specimen);
            currentAttempt++;
        }
    }


    private boolean stopCondition(){
        if (currentAttempt>0 && score==0){
            return true;
        }
        else if (currentAttempt==maxAttempts){
            return true;
        }
        return false;
    }

    public Specimen getSolution(){
        return specimen;
    }

    public int getScore(){
        return score;
    }

    public int getCurrentAttempt(){
        return currentAttempt;
    }
}
