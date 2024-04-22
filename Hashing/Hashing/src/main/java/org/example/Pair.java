package org.example;

import java.util.ArrayList;

public class Pair<T>{
    private T value;
    private ArrayList<T> secondaryLevel;

    public Pair(T value, ArrayList<T> secondaryLevel) {
        this.value = value;
        this.secondaryLevel = secondaryLevel;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setSecondaryLevel(ArrayList<T> secondaryLevel) {
        this.secondaryLevel = secondaryLevel;
    }

    public T getValue() {
        return value;
    }

    public ArrayList<T> getSecondaryLevel() {
        return secondaryLevel;
    }
}
