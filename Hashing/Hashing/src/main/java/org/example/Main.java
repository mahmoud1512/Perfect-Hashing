package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int getRandomZeroOne() {
        Random random = new Random();
        return random.nextInt(2);
    }

    static int[][] createHashFunction(int bNumberOfIndices, int bKey){
        int[][]arr = new int[bNumberOfIndices][bKey];
        for(int i = 0; i < bNumberOfIndices; i++){
            for(int j = 0; j < bKey; j++)
                arr[i][j] = getRandomZeroOne();
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IntegerHash integerHash = new IntegerHash(true);
        for(int i = 0 ; i < 10000; i++){
            integerHash.insert(i);
        }
        for(int i = 0; i < 100; i++){
            integerHash.delete(i);
        }
        integerHash.delete(50);
        System.out.println(integerHash.search(40));
        System.out.println(integerHash.search(100));
        System.out.println(integerHash.search(430));
        System.out.println(integerHash.search(4021));
        System.out.println(integerHash.getNumberOfRehash());
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