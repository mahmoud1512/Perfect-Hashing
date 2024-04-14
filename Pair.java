package com.Signalflowgraphs.Signalflowgraphs.Moduels;

public class Pair {
    private int destination, weight;

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public Pair(int destination, int weight){
        this.destination = destination;
        this.weight = weight;
    }
}
