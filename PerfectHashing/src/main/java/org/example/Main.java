package org.example;

import org.example.HashTable.HashTable;
import org.example.Methods.NSpace;
import org.example.Methods.NSquareSpace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
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

    public static ArrayList<String> readDataFromFile(String filePath) {
        ArrayList<String> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static void main(String[] args) {
        while(true) {
            mainProgram();
        }

//        NSpace<Integer> nSpace = new NSpace<>(32, 10);
//        NSpace<Integer> nSpace = new NSpace<>(32, 100);

//        for (int i = 0; i <= 10000; i++)
//            nSpace.insert(i);
//
//        System.out.println(nSpace.search(50));
//        System.out.println(nSpace.search(50000));
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 100; i <= 500; i++)
//            arrayList.add(i);
//
//        System.out.println(Arrays.toString(nSpace.batchDelete(arrayList)));
//
//        System.out.println(nSpace.search(354));
//
//        arrayList = new ArrayList<>();
//
//        for (int i = 200; i <= 1000; i++)
//            arrayList.add(i);
//
//        System.out.println(Arrays.toString(nSpace.batchDelete(arrayList)));
//
//        System.out.println(nSpace.getNumberOfRehash());
//
//        System.out.println(nSpace.getSize());
//
//        System.out.println("------------------------------------------------------");
//
//        NSquareSpace<Integer> nSquare = new NSquareSpace<>(32);


//        NSquareSpace<Integer> nSquare = new NSquareSpace<>(32);

//        for (int i = 0; i <= 10000; i++)
//            nSquare.insert(i);
//
//        System.out.println(nSquare.search(100));
//        System.out.println(nSquare.search(1000000));
//
//        arrayList = new ArrayList<>();
//        for (int i = 100; i <= 500; i++)
//            arrayList.add(i);
//
//        System.out.println(Arrays.toString(nSquare.batchDelete(arrayList)));
//
//        System.out.println(nSquare.search(354));
//
//        arrayList = new ArrayList<>();
//        nSquare.batchInsert(arrayList);
//
//        for (int i = 200; i <= 1000; i++)
//            arrayList.add(i);
//
//        System.out.println(Arrays.toString(nSquare.batchInsert(arrayList)));
//
//        System.out.println(nSquare.getNumberOfRehash());
//        System.out.println(nSquare.getSize());



//        Scanner sc = new Scanner(System.in);
//
//        FloatHash floatHash = new FloatHash();
//        for(float i = 0 ; i < 10000; i += 0.5){
//            floatHash.insert(i);
//        }
//        System.out.println(floatHash.getNumberOfRehash());

//        IntegerHash integerHash = new IntegerHash();
//        for(int i = 0 ; i < 10000; i++){
//            integerHash.insert(i);
//        }
//        for(int i = 0; i < 100; i++){
//            integerHash.delete(i);
//        }
//        integerHash.delete(50);
//        System.out.println(integerHash.search(40));
//        System.out.println(integerHash.search(100));
//        System.out.println(integerHash.search(430));
//        System.out.println(integerHash.search(4021));
//        System.out.println(integerHash.getNumberOfRehash());

//        int tests = 10000;
//        int max = 0;
//        while (tests > 0) {
//            tests--;
//            StringHash stringHash = new StringHash();
//            stringHash.insert("abandon");
//            stringHash.insert("ability");
//            stringHash.insert("able");
//            stringHash.insert("absorb");
//            stringHash.insert("accompany");
//            stringHash.insert("achievement");
//            stringHash.insert("acknowledge");
//            stringHash.insert("action");
//            stringHash.insert("cause");
//            stringHash.insert("Catholic");
//            stringHash.insert("CEO");
//            stringHash.insert("boat");
//            stringHash.insert("bombing");
//            stringHash.insert("bone");
//            stringHash.insert("Congress");
//            stringHash.insert("dramatically");
//            stringHash.insert("drink");
//            stringHash.insert("dry");
//            stringHash.insert("eager");
//            stringHash.insert("finding");
//            stringHash.insert("finish");
//            stringHash.insert("first");
//            stringHash.insert("growing");
//            stringHash.insert("highly");
//            stringHash.insert("painful");
//
//            max = Math.max(stringHash.getNumberOfRehash(), max);
//        }
//        System.out.println(max);

//        LongHash longHash = new LongHash();
//        for(long i = 0 ; i < 10000; i++){
//            longHash.insert(i);
//        }
//        for(long i = 0; i < 100; i++){
//            longHash.delete(i);
//        }
//        longHash.delete(50L);
//        System.out.println(longHash.search(40L));
//        System.out.println(longHash.search(100L));
//        System.out.println(longHash.search(430L));
//        System.out.println(longHash.search(4021L));
//        System.out.println(longHash.getNumberOfRehash());
//        while(true){
//            int x = scanner.nextInt();
//            integerHash.insert(x);
//        }

    }
//        int bKey = (int)Math.floor(Math.log10(5) / Math.log10(2)) + 1;
//        int bNumberOfIndices = (int)Math.floor(Math.log10(5) / Math.log10(2)) + 1;
//        int[][] arr = createHashFunction(bNumberOfIndices, bKey);
//
//        for(int i = 0; i < bNumberOfIndices; i++){
//            for(int j = 0; j < bKey; j++)
//                System.out.print(arr[i][j] + " ");
//            System.out.println();
//        }
//        ArrayList<Integer> arrayList = new ArrayList<>(5);
//        for (int i = 0; i < 5; i++) {
//            arrayList.add(null);
//        }
//        arrayList.add(0, 2);
//        arrayList.add(1, 2);
//        arrayList.set(1, null);
//
////        for(int i = 0; i < 5; i++)
////            System.out.println(arrayList.get(i));
//
////        System.out.println(Integer.MIN_VALUE);
//        String s = Integer.toBinaryString(Integer.MAX_VALUE);
//        System.out.println(s.length());

//        int key = 12;
//        String binaryString = Integer.toBinaryString(key);
//        int len = binaryString.length();
//        ArrayList<Integer> binaryKey = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            if (binaryString.charAt(i) == '0') {
//                binaryKey.add(i, 0);
//            } else {
//                binaryKey.add(i, 1);
//            }
//        }
//        while (len < 32) {
//            binaryKey.add(0, 0);
//            len++;
//        }
//        for(Integer x: binaryKey)
//            System.out.print(x);
//    }

    public static void mainProgram() {
        HashTable<String> hashtable;
        Scanner sc = new Scanner(System.in);
        System.out.println("choose the type of the dictionary");
        System.out.println("1- N space dictionary");
        System.out.println("2- N² space dictionary");
        int dictionaryType = sc.nextInt();
        if (dictionaryType == 1)
            hashtable = new NSpace<>(80, 16);
        else
            hashtable = new NSquareSpace<>(80, 16);
        int[] operationStatus;
        boolean loop = true;
        while(loop) {
            System.out.println("choose the operation to perform on the dictionary");
            System.out.println("1- Insert");
            System.out.println("2- Delete");
            System.out.println("3- Search");
            System.out.println("4- Batch insert");
            System.out.println("5- Batch delete");
            System.out.println("6- reset");

            int choice = sc.nextInt();
            String text;
            ArrayList<String> keys;

            switch (choice) {
                case 1:
                    System.out.println("enter the key you want to insert");
                    text = sc.nextLine();
                    text = sc.nextLine();
                    sc.nextLine();
                    System.out.println((hashtable.insert(text)) ? "key inserted successfully"
                                                                : "the key you are trying to insert already exists");
                    break;
                case 2:
                    System.out.println("enter the key you want to delete");
                    text = sc.nextLine();
                    text = sc.nextLine();
                    sc.nextLine();
                    System.out.println((hashtable.delete(text)) ? "key deleted successfully"
                                                                : "the key you are trying to delete doesn't exist");
                    break;
                case 3:
                    System.out.println("enter the key you want to search for");
                    text = sc.nextLine();
                    text = sc.nextLine();
                    sc.nextLine();
                    System.out.println((hashtable.search(text)) ? "the key you're trying to search for exists"
                                                                : "the key you're trying to search for doesn't exist");
                    break;
                case 4:
                    System.out.println("enter the path to the file containing keys you want to insert");
                    text = sc.nextLine();
                    text = sc.nextLine();
                    //System.out.println(text);
                    keys = hashtable.readDataFromFile(text);
                    operationStatus = hashtable.batchInsert(keys);
                    System.out.println("number of newly inserted elements = " + operationStatus[1]);
                    System.out.println("number of already existing elements = " + operationStatus[0]);
                    break;
                case 5:
                    System.out.println("enter the path to the file containing keys you want to delete");
                    text = sc.nextLine();
                    text = sc.nextLine();
                    //System.out.println(text);
                    keys = hashtable.readDataFromFile(text);
                    operationStatus = hashtable.batchDelete(keys);
                    System.out.println("number of deleted elements = " + operationStatus[0]);
                    System.out.println("number of non existing elements = " + operationStatus[1]);
                    break;
                case 6:
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}