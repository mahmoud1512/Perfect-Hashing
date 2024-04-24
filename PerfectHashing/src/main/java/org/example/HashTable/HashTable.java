package org.example.HashTable;

import org.example.Hash;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HashTable<T> implements Hash<T> {
//    hash function of hash table
    protected HashFunction<T> hashFunction;
//    size of hash table (based on type of hash)
    protected int hashTableSize = 16;
//    construct default hash table
    protected ArrayList<T> table;
    protected int numberOfRehash = 0;

    protected int getIndex(T key) {
//        convert to binary array
        ArrayList<Integer> binaryKeyArray = hashFunction.convertToBinaryArray(key);
//        hash matrix * binaryKeyArray
        return hashFunction.multiplication(binaryKeyArray);
    }

    protected Integer getStatus(T key){
//        get index of key
        int index = getIndex(key);

//        empty bucket
        if (Objects.equals(table.get(index), null)){
            return -1;
        }
//        same index and same key
        else if (Objects.equals(key, table.get(index))){
            return 1;
        }
//        same index and different key
        else {
            return 0;
        }
    }

    public ArrayList<T> readFromFile(String path) {
        ArrayList<T> list = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                T object = parseLineToObject(line);
//                if (object != null) {
//                    list.add(object);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            // Specify the file path
            File file = new File(path);

            // Create a Scanner to read the file
            Scanner scanner = new Scanner(file);

            // Read and print each line of the file
            while (scanner.hasNextLine()) {
                list.add((T) scanner.nextLine());
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            // Print the error message
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
    @Override
    public void insert(T key) {

    }

    @Override
    public void delete(T key) {

    }

    @Override
    public Boolean search(T key) {
        return null;
    }

    @Override
    public int[] batchInsert(ArrayList<T> keys) {
        return new int[0];
    }

    @Override
    public int[] batchDelete(ArrayList<T> keys) {
        return new int[0];
    }
}
