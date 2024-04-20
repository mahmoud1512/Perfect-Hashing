package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class IntegerHash implements Hash<Integer> {
    private int[][]hashFunction;
    private ArrayList<Integer>hashTableNSquare;
    private ArrayList<Pair<Integer>>hashTableN;
    private int hashTableSize;
    private Double loadFactor;
    private int numOfElements;
    private boolean nSpaceSolution = false;
    private boolean nSquareSolution = false;
    final int numberOfKeyBits = 32;
    int numberOfIndexBits;
    int numberOfRehash;
    static int getRandomZeroOne() {
        Random random = new Random();
        return random.nextInt(2);
    }
    private int[][] createHashFunction(int numberOfIndexPits){
        int[][]arr = new int[numberOfIndexPits][32];
        for(int i = 0; i < numberOfIndexPits; i++){
            for(int j = 0; j < 32; j++)
                arr[i][j] = getRandomZeroOne();
        }
        return arr;
    }

    private void nSpaceSolutionInitialize(){
        nSpaceSolution = true;
        hashTableN = new ArrayList<>(hashTableSize);
        for(int i = 0; i < hashTableSize; i++){
            hashTableN.add(i, new Pair<>(null));
        }
        numberOfIndexBits = (int)Math.floor(Math.log10(hashTableSize) / Math.log10(2));
    }
    private void nSquareSolutionInitialize(){
        nSquareSolution = true;
        hashTableNSquare = new ArrayList<>(Collections.nCopies(hashTableSize*hashTableSize, null));
        numberOfIndexBits = (int)Math.ceil(Math.log10(hashTableSize*hashTableSize) / Math.log10(2));
    }
    IntegerHash(boolean NSpaceSolution){
        hashTableSize = 16; // Default size as java map
        numberOfRehash = 0;

        if(NSpaceSolution){
          nSpaceSolutionInitialize();
        }
        else{
          nSquareSolutionInitialize();
        }
        hashFunction = createHashFunction(numberOfIndexBits);
        numOfElements = 0;
        loadFactor = 0.0;

        for (int i = 0; i < numberOfIndexBits; i++){
            for(int j = 0; j < numberOfKeyBits; j++){
                System.out.print(hashFunction[i][j] + " ");
            }
            System.out.println();
        }
    }
    private int getIndex(int[][] matrix, Integer key) {
        String binaryString = Integer.toBinaryString(key);
        int len = binaryString.length();
        ArrayList<Integer>binaryKey = new ArrayList<>();
        for(int i = 0;i < len; i++){
            if(binaryString.charAt(i) == '0'){
                binaryKey.add(i, 0);
            }
            else{
                binaryKey.add(i, 1);
            }
        }
        while(len < 32){
            binaryKey.add(0, 0);
            len++;
        }
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j] * binaryKey.get(j);
            }
            sum %= 2;
            result += (sum * Math.pow(2, i));
        }
        return result;
    }
    void reHashNSquare(ArrayList<Integer> integers){ // recursion function
        numberOfRehash++;
        hashTableSize = integers.size();
        numberOfIndexBits = (int)Math.floor(Math.log10(hashTableSize * hashTableSize) / Math.log10(2));
        hashTableNSquare = new ArrayList<>(Collections.nCopies(hashTableSize*hashTableSize, null));
        hashFunction = createHashFunction(numberOfIndexBits);

        for(Integer integer: integers){
            int index = getIndex(hashFunction, integer);
            if(hashTableNSquare.get(index) != null) {
                reHashNSquare(integers);
            }
            else{
                hashTableNSquare.set(index, integer);
            }
        }
    }
    private void insertInNSquare(Integer key, int index){
        if(Objects.equals(hashTableNSquare.get(index), null)) {
            hashTableNSquare.set(index, key);
        }
        else if(Objects.equals(hashTableNSquare.get(index), key)){
            System.out.println("The integer you need to insert is already exist");
        }
        else{
            ArrayList<Integer>integers = new ArrayList<>();
            for(Integer integer : hashTableNSquare) {
                if(integer != null)
                    integers.add(integer);
            }
            integers.add(key);
            reHashNSquare(integers);
        }
    }
    private void insertInN(Integer key, int index){

    }
    @Override
    public void insert(Integer key) {
        int index = getIndex(hashFunction, key);
        if(nSquareSolution){
            insertInNSquare(key, index);
        }
        else{
            insertInN(key, index);
        }
    }
    private void deleteNSquare(Integer key){
        int index = getIndex(hashFunction, key);
        if(hashTableNSquare.get(index) == null){
            System.out.println("The element is not exit to delete it!!!");
        }else {
            hashTableNSquare.set(index, null);
        }
    }
    private void deleteN(Integer key){
        int index = getIndex(hashFunction, key);

    }
    @Override
    public void delete(Integer key) {
        if(nSquareSolution)
            deleteNSquare(key);
        else
            deleteN(key);
    }

    @Override
    public boolean search(Integer key) {
        int index = getIndex(hashFunction, key);

        if(nSquareSolution){
            return hashTableNSquare.get(index) != null;
        }
//        else{ nMethod
//        }
        return true;
    }
    private ArrayList<Integer> readKeysFromFile(String filePath) {
        ArrayList<Integer> integersList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    integersList.add(number);
                } catch (NumberFormatException e) {
                    // Handle invalid integer format
                    System.err.println("Invalid integer format: " + line);
                }
            }
        } catch (IOException e) {
            // Handle file IO exception
            System.err.println("Error reading file: " + e.getMessage());
        }
        return integersList;
    }

    private void batchInsertNSquare(ArrayList<Integer> keys){
        ArrayList<Integer>Distinct = new ArrayList<>();
        for(Integer integer: keys){
            int index = getIndex(hashFunction, integer);
            if(hashTableNSquare.get(index) != null && Objects.equals(hashTableNSquare.get(index), integer)){
                System.out.println("integer " + integer + "is already exist");
            }else if(!Distinct.contains(integer)){
                Distinct.add(integer);
            }
        }
        for(Integer integer: hashTableNSquare){
            if(integer != null)
                Distinct.add(integer);
        }
        reHashNSquare(Distinct);
    }
    private void batchInsertN(ArrayList<Integer> keys){

    }
    @Override
    public void batchInsert(String path) {
        ArrayList<Integer>keys = readKeysFromFile(path);
        if(nSquareSolution)
            batchInsertNSquare(keys);
        else
            batchInsertN(keys);
    }
    void batchDeleteNSquare(ArrayList<Integer> keys){
        for(Integer integer: keys){
            int index = getIndex(hashFunction, integer);
            if(hashTableNSquare.get(index) == null)
                System.out.println("The element " + integer + " already does not exist in the table");
            hashTableNSquare.set(index, null);
        }
    }
    void batchDeleteN(ArrayList<Integer> keys){

    }
    @Override
    public void batchDelete(String path) {
        ArrayList<Integer>keys = readKeysFromFile(path);
        if(nSquareSolution)
            batchDeleteNSquare(keys);
        else
            batchDeleteN(keys);
    }

    public int getNumberOfRehash(){
        return numberOfRehash;
    }
}
