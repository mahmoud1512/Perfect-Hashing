package org.example;

import java.util.ArrayList;

public class Pair<T> {
    T value;
    ArrayList<T> collisions;
    int[][] hashFunction;

    Pair(T value) {
        this.value = value;
        collisions = new ArrayList<>();
    }

}
