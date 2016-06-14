package com.company;

import com.company.utils.Edge;
import com.company.utils.Node;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by agnie on 3/10/2016.
 */
public class Graph {

    private ArrayList<Node> nodes = new ArrayList<Node>();
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private int numberOfNodes;
    private int numberOfEdges;

    public void readGraph(File file){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line!=null){
                ArrayList<Integer> row = new ArrayList<Integer>();
                if (line.charAt(0)=='p'){
                    String temporaryArray[] = line.split("\\s+");
                    numberOfNodes = Integer.parseInt(temporaryArray[2]);
                    numberOfEdges = Integer.parseInt(temporaryArray[3]);
                    line = reader.readLine();
                }
                else if (line.charAt(0)=='e'){
                    String temporaryArray[] = line.split("\\s+");
                    row.add(Integer.parseInt(temporaryArray[1]));
                    row.add(Integer.parseInt(temporaryArray[2]));
                    row.add(Integer.parseInt(temporaryArray[3]));
//                    System.out.println(row);
                    edges.add(new Edge(row.get(0), row.get(1), row.get(2)));
                    line = reader.readLine();
                }
                else if (line.charAt(0)=='n'){
                    String temporaryArray[] = line.split("\\s+");
                    row.add(Integer.parseInt(temporaryArray[1]));
                    row.add(Integer.parseInt(temporaryArray[2]));
//                    System.out.println(row);
                    nodes.add(new Node(row.get(0), row.get(1)));
                    line = reader.readLine();
                }
                else {
                    line = reader.readLine();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getNumberOfNodes(){
        return numberOfNodes;
    }

    public int getNumberOfEdges(){
        return numberOfEdges;
    }

    public ArrayList<Edge> getEdges(){
        return edges;
    }

    public ArrayList<Node> getNodes(){
        return nodes;
    }

}
