package org.example.HashTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HashTable<T>{
//    hash function of hash table
    protected HashFunction hashFunction;
//    hash table
    protected ArrayList<T> table;
//    size of hash table (based on type of hash)
    protected int hashTableSize;
    protected int numberOfRehash;
    protected ArrayList<T> readFromFile(String path) {
        ArrayList<T> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T object = parseLineToObject(line);
                if (object != null) {
                    list.add(object);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private T parseLineToObject(String line) {
        // Implement parsing logic based on your requirements
        // This is just a placeholder method
        @SuppressWarnings("unchecked")
        T parsedObject = (T) line; // Assuming each line represents an object of type T
        return parsedObject;
    }

}
