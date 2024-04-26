package org.example.Dictionary;

import org.example.Hash;
import org.example.HashTable.HashTable;
import org.example.HashTypeFactory;
import org.example.Methods.NSpace;
import org.example.Methods.NSquareSpace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary implements IDictionary{
    HashTable<String> hashTable;

    public static <T> ArrayList<T> readDataFromFile(String filePath) {
        ArrayList<T> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming data in each line is of type T
                dataList.add((T) line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    @Override
    public void startingProgram() {
        while (true) {
            intro();
            initialization();
            int[] operationStatus;
            boolean loop = true;
            while (loop) {
                System.out.println("choose the operation to perform on the dictionary");
                System.out.println("1- Insert");
                System.out.println("2- Delete");
                System.out.println("3- Search");
                System.out.println("4- Batch insert");
                System.out.println("5- Batch delete");
                System.out.println("6- Hash table size");
                System.out.println("0- reset");

                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                String text;
                ArrayList<String> keys;

                switch (choice) {
                    case 1 -> {
                        System.out.println("enter the key you want to insert");
                        text = sc.nextLine();
                        text = sc.nextLine();
                        sc.nextLine();
                        System.out.println((hashTable.insert(text)) ? "key inserted successfully"
                                : "the key you are trying to insert already exists");
                    }
                    case 2 -> {
                        System.out.println("enter the key you want to delete");
                        text = sc.nextLine();
                        text = sc.nextLine();
                        sc.nextLine();
                        System.out.println((hashTable.delete(text)) ? "key deleted successfully"
                                : "the key you are trying to delete doesn't exist");
                    }
                    case 3 -> {
                        System.out.println("enter the key you want to search for");
                        text = sc.nextLine();
                        text = sc.nextLine();
                        sc.nextLine();
                        System.out.println((hashTable.search(text)) ? "the key you're trying to search for exists"
                                : "the key you're trying to search for doesn't exist");
                    }
                    case 4 -> {
                        System.out.println("enter the path to the file containing keys you want to insert");
                        text = sc.nextLine();
                        text = sc.nextLine();
                        //System.out.println(text);
                        keys = readDataFromFile(text);
                        operationStatus = hashTable.batchInsert(keys);
                        System.out.println("number of newly inserted elements = " + operationStatus[1]);
                        System.out.println("number of already existing elements = " + operationStatus[0]);
                    }
                    case 5 -> {
                        System.out.println("enter the path to the file containing keys you want to delete");
                        text = sc.nextLine();
                        text = sc.nextLine();
                        //System.out.println(text);
                        keys = readDataFromFile(text);
                        operationStatus = hashTable.batchDelete(keys);
                        System.out.println("number of deleted elements = " + operationStatus[0]);
                        System.out.println("number of non existing elements = " + operationStatus[1]);
                    }
                    case 6 -> {
                        System.out.println("size of hash table = " + hashTable.getHashTableSize());
                    }
                    case 0 -> loop = false;
                    default -> {
                    }
                }
            }
        }
    }

    @Override
    public void initialization() {
        Scanner sc = new Scanner(System.in);
        System.out.println("choose the type of the dictionary");
        System.out.println("1- N space dictionary");
        System.out.println("2- N² space dictionary");

        String dictionaryType = sc.nextLine();
        HashTypeFactory<String> hashTypeFactory = new HashTypeFactory<>();
        hashTable = hashTypeFactory.getFactory(dictionaryType, 80, 16);
    }

    @Override
    public void intro() {
        System.out.println("***************************************************");
        System.out.println("***********Welcome In English Dictionary***********");
        System.out.println("***************************************************");
    }

}
