package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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

    public static void main(String[] args) {
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

}