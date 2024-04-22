package org.example.HashTable;

public class Pair<T> {
    protected T value;
    protected HashTable<T> hashTable;
    Pair(T value) {
        this.value = value;
//        collisions = new ArrayList<>();
    }
}
