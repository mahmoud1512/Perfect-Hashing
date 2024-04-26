package org.example;

import org.example.HashTable.HashTable;
import org.example.Methods.NSpace;
import org.example.Methods.NSquareSpace;

public class HashTypeFactory <T>{
    public HashTable<T> getFactory(String method, int numberOfMaxKeyBits, int hashTableSize){
        return switch (method) {
            case "NSpace" -> new NSpace<>(numberOfMaxKeyBits, hashTableSize);
            case "NSquareSpace" -> new NSquareSpace<>(numberOfMaxKeyBits, hashTableSize);
            default -> null;
        };
    }
}
