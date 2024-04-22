package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

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
    public int newSize2;
    List<Pair<Integer>> mainHashTable;

    public int numofrehash;
    public int newSize;
    private int[][] mainrandomMatrix;
    private  int[][] randomMatrix;
    private  List<Integer> secondLevelHashTable;
    private Map<Integer, ArrayList<Integer>> collisionindexelemnts;
    private List<Integer> clollisionelements;

    private ArrayList<Integer> existance;
    boolean resizesecoundlevel;





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
    private int[][] createRandomMatrix(int rows, int cols) {
        int[][]arr = new int[rows][32];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < 32; j++)
                arr[i][j] = getRandomZeroOne();
        }
        return arr;
    }


    private void nSpaceSolutionInitialize(){
        mainrandomMatrix= createRandomMatrix(16, 32);
        numofrehash = 0;
        mainHashTable = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            mainHashTable.add(null);
        }
        secondLevelHashTable = new ArrayList<>();
        collisionindexelemnts = new HashMap<>();
        clollisionelements = new ArrayList<>();
        existance=new ArrayList<>();
        resizesecoundlevel=false;
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
    private void insertInN(Integer element){
        if(this.existance.contains(element))
        {
            System.out.println("element is founded ");
            return;
        }
        this.existance.add(element);
        clollisionelements = new ArrayList<>();
        int index = getIndex(mainrandomMatrix,element);
        if (mainHashTable.get(index) == null) {
            mainHashTable.set(index, new Pair<>(element, new ArrayList<>()));
            clollisionelements.add(element);
            collisionindexelemnts.put(index, (ArrayList<Integer>) clollisionelements);
        } else {
            ArrayList<Integer> collisionElements = new ArrayList<>(collisionindexelemnts.get(index));
            collisionElements.add(element);
            collisionindexelemnts.put(index, (ArrayList<Integer>) collisionElements);
            this.newSize = collisionindexelemnts.get(index).size() * collisionindexelemnts.get(index).size();
            int numberOfIndexBits = (int)Math.floor(Math.log10(newSize) / Math.log10(2));
            randomMatrix = createRandomMatrix(numberOfIndexBits, 32);
            ArrayList<Integer> secondLevelHashTable = new ArrayList<>(this.newSize);
            secondLevelHashTable = new ArrayList<>(Collections.nCopies(newSize, null));
            int newIndex = 0;
            for (int v : collisionindexelemnts.get(index)) {
                boolean re = false;
                newIndex =getIndex(randomMatrix,element);;
                if (secondLevelHashTable.get(newIndex) == null) {
                    secondLevelHashTable.set(newIndex, v);
                    mainHashTable.get(index).setSecondaryLevel((ArrayList<Integer>) secondLevelHashTable);
                } else {
                    rehashSecondLevel(index);

                }
            }
        }

    }
    private void rehashSecondLevel(int index) {
        numofrehash++;
        int originalSize = collisionindexelemnts.get(index).size();
        int numberOfIndexBits = (int)Math.floor(Math.log10(originalSize * originalSize) / Math.log10(2));
        randomMatrix = createRandomMatrix(numberOfIndexBits, 32);
        this.newSize2=originalSize*originalSize;
        ArrayList<Integer> newSecondLevel = new ArrayList<>(newSize2);
        newSecondLevel = new ArrayList<>(Collections.nCopies(newSize2, null));
        for (int element : collisionindexelemnts.get(index)) {
            int newIndex =getIndex(randomMatrix,element);;
            if (newSecondLevel.get(newIndex) == null) {
                newSecondLevel.set(newIndex, element);
                mainHashTable.get(index).setSecondaryLevel(newSecondLevel);
            } else {
                rehashSecondLevel(index);
            }
        }
    }
    @Override
    public void insert(Integer key) {
        if(nSquareSolution){
            int index = getIndex(hashFunction, key);
            insertInNSquare(key, index);
        }
        else{
            insertInN(key);
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
    private void deleteN(Integer element){
        Boolean existStatus = this.existance.contains(element);
        if (existStatus) {
            this.existance.remove(existance.indexOf(element));
            int index = getIndex(mainrandomMatrix,element);
            Pair<Integer> foundElement = mainHashTable.get(index);
            System.out.println("Deleted element is : " + element + " at index " + index);
            if (foundElement != null && foundElement.getValue() == element) {
                mainHashTable.set(index, null);
            } else {
                ArrayList<Integer> secondLevel = mainHashTable.get(index).getSecondaryLevel();
                if (secondLevel.contains(element)) {
                    secondLevel.remove(Integer.valueOf(element));
                }
            }
        } else {
            System.out.println("Element " + element + " not found, no action taken.");
        }

    }
    @Override
    public void delete(Integer key) {
        if(nSquareSolution)
            deleteNSquare(key);
        else
            deleteN(key);
    }
    private int[] positionofelement(int element) {
        if(!this.existance.contains(element)) {
            return null;
        }
        int index =getIndex(mainrandomMatrix,element);
        Pair<Integer> foundElement = mainHashTable.get(index);
        ArrayList<Integer> secondLevel = mainHashTable.get(index).getSecondaryLevel();
        int[] position = new int[2];
        if (foundElement != null && foundElement.getValue() == element && secondLevel.isEmpty()) {
            position[0] = index;
            position[1] = -1; // Element found in main hash table without secondary level
        } else if (secondLevel.contains(element)) {
            position[0] = index;
            position[1] = secondLevel.indexOf(element); // Element found in secondary level
        }
        return position;
    }
    public boolean isfounded(int element)
    {
        int[] p=this.positionofelement(element);
        if(p==null)
            return false;
        else
            return true;

    }

    @Override
    public boolean search(Integer key) {


        if(nSquareSolution){
            int index = getIndex(hashFunction, key);
            return hashTableNSquare.get(index) != null;
        }
        else{
            return  isfounded(key);
        }


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
    public void batchInsertN(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                int element = Integer.parseInt(line.trim());
                insertInN(element);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void batchInsert(String path) {
        ArrayList<Integer>keys = readKeysFromFile(path);
        if(nSquareSolution)
            batchInsertNSquare(keys);
        else
            batchInsertN(path);
    }
    void batchDeleteNSquare(ArrayList<Integer> keys){
        for(Integer integer: keys){
            int index = getIndex(hashFunction, integer);
            if(hashTableNSquare.get(index) == null)
                System.out.println("The element " + integer + " already does not exist in the table");
            hashTableNSquare.set(index, null);
        }
    }
    void batchDeleteN(String filePath){
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                int element = Integer.parseInt(line.trim()); // Assuming the file contains integer elements
                deleteN(element);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void batchDelete(String path) {
        ArrayList<Integer>keys = readKeysFromFile(path);
        if(nSquareSolution)
            batchDeleteNSquare(keys);
        else
            batchDeleteN(path);
    }

    public int getNumberOfRehash(){
        return numberOfRehash;
    }
    public int NgetNumberOfRehash(){
        return numofrehash;
    }

}
