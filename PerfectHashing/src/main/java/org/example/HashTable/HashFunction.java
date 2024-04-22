package org.example.HashTable;

import java.util.ArrayList;
import java.util.Random;

public class HashFunction {
    private int numberOfMaxKeyBits;

    private int[][] hashMatrix;

    private int numberOfIndexBits;
    private static int getRandomZeroOne() {
        Random random = new Random();
        return random.nextInt(2);
    }
    public void createHashMatrix(){
        hashMatrix = new int[numberOfIndexBits][numberOfMaxKeyBits];
        for(int i = 0; i < numberOfIndexBits; i++){
            for(int j = 0; j < numberOfMaxKeyBits; j++)
                hashMatrix[i][j] = getRandomZeroOne();
        }
    }

    public ArrayList<Integer> convertToBinaryArray(String binaryString){
        int len = binaryString.length();
        ArrayList<Integer> binaryKey = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(binaryString.charAt(i) == '0'){
                binaryKey.add(i, 0);
            }
            else{
                binaryKey.add(i, 1);
            }
        }

        while(len < numberOfMaxKeyBits){
            binaryKey.add(0, 0);
            len++;
        }

        return binaryKey;
    }

    public int multiplication(ArrayList<Integer> binaryKeyArray){
        int result = 0;
        int rows = hashMatrix.length;
        int cols = hashMatrix[0].length;

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += hashMatrix[i][j] * binaryKeyArray.get(j);
            }
            sum %= 2;
            result += (sum * Math.pow(2, i));
        }
        return result;
    }
    public void setNumberOfMaxKeyBits(int numberOfMaxKeyBits) {
        this.numberOfMaxKeyBits = numberOfMaxKeyBits;
    }
    public void setNumberOfIndexBits(int numberOfIndexBits) {
        this.numberOfIndexBits = numberOfIndexBits;
    }
}
