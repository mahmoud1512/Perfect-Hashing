package org.example;

import org.example.HashTable.HashFunction;
import org.example.HashTable.HashTable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class IntegerHash<T> extends HashTable<T> implements Hash<T> {
    private final int maxKeyBits;

    public IntegerHash(int maxKeyBits, int hashTableSize) {
        this.maxKeyBits = maxKeyBits;
        initialization();
    }
    public void initialization(){
        numberOfRehash = 0;
//        default Size
        hashTableSize = 16;
//        construct hash table
        table = new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
//        ------------------------------------------------------------------------------------------------------------------
//        initialize hash function
        hashFunction = new HashFunction();

        hashFunction.setNumberOfMaxKeyBits(maxKeyBits);
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log10(hashTableSize * hashTableSize / Math.log10(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();
    }
//    private String convertFloatToBinary(Float key){
//        int intValue = Float.floatToIntBits(key);
//        return Integer.toBinaryString(intValue);
//    }
//    private String convertDoubleToBinary(Double key){
//        long longValue = Double.doubleToLongBits(key);
//        return Long.toBinaryString(longValue);
//    }
//    private String convertStringToBinary(String key){
//        long stringToLongKey = generateHashCode(key);
//        return Long.toBinaryString(stringToLongKey);
//    }
//    private long generateHashCode(String input) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hashBytes = digest.digest(input.getBytes());
//            long hashCode = 0;
//            for (int i = 0; i < 8; i++) {
//                hashCode |= (long) (hashBytes[i] & 0xFF) << (8 * i);
//            }
//            return hashCode;
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return -1; // Error case
//        }
//    }
////          convert float to binary string
//    private String convertToBinary(T key){
//        if(key instanceof Integer)
//            return Integer.toBinaryString((Integer) key);
//        else if(key instanceof Float)
//            return convertFloatToBinary((Float) key);
//        else if(key instanceof Double)
//            return convertDoubleToBinary((Double) key);
//        else if(key instanceof String)
//            return convertStringToBinary((String)key);
//        else // long
//            return Long.toBinaryString((Long) key);
//    }

//    private int getIndex(T key) {
////        convert to binary
//        String binaryKeyString = hashFunction.convertToBinary(key);
////        convert to binary array
//        ArrayList<Integer> binaryKeyArray = hashFunction.convertToBinaryArray(binaryKeyString);
////        hash matrix * binaryKeyArray
//        return hashFunction.multiplication(binaryKeyArray);
//    }

    private ArrayList<T> getKeys(){
        ArrayList<T> keys = new ArrayList<>();
        for(T key : table) {
            if(key != null)
                keys.add(key);
        }
        return keys;
    }

    private void rehash(ArrayList<T> arrayOfKeys){ // recursion function

        numberOfRehash++;
        hashTableSize = arrayOfKeys.size();
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log10(hashTableSize * hashTableSize) / Math.log10(2)));
//        resize
        table= new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
//        rehash
        hashFunction.createHashMatrix();

        for(T key: arrayOfKeys){
            if(search(key) == 0) {
                rehash(arrayOfKeys);
            }
            else{
//                get index of key
                int index = getIndex(key);
                table.set(index, key);
            }
        }
    }

    public int getNumberOfRehash(){
        return numberOfRehash;
    }

    @Override
    public void insert(T key) {
//        get index of key
        int index = getIndex(key);
//        empty bucket (insert)
        if(search(key) == -1) {
            table.set(index, key);
        }
//        same index and same key (warning message)
        else if(search(key) == 1){
            System.out.println("The integer you need to insert is already exist");
        }
//        same index and different key (rehash)
        else{
//            get keys from old hash table
            ArrayList<T> arrayOfKeys = getKeys();
            arrayOfKeys.add(key);
//            resize and rehash
            rehash(arrayOfKeys);
        }
    }

    @Override
    public void delete(T key) {
//        empty bucket || same index and different key (warning message)
        if(search(key) == -1 || search(key) == 0) {
            System.out.println("The element is not exit to delete it!!!");
        }
//        same index and same key (delete)
        else{
//            get index of key
            int index = getIndex(key);

            table.set(index, null);
        }
    }

    @Override
    public int search(T key) {

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
//       same index and different key
        else {
            return 0;
        }
    }


    @Override
    public void batchInsert(String path) {
        ArrayList<T> keys = readFromFile(path);
        ArrayList<T> distinct = new ArrayList<>();
        for(T key: keys){
            if(search(key) == 1){
                System.out.println("element " + key + " is already exist");
            }
            else if(!distinct.contains(key)){
                distinct.add(key);
            }
        }
        for(T key: table){
            if(key != null)
                distinct.add(key);
        }
        rehash(distinct);
    }

    @Override
    public void batchDelete(String path) {
        ArrayList<T> keys = readFromFile(path);
        for(T key: keys){
            if(search(key) == -1 || search(key) == 0)
                System.out.println("The element " + key + " already does not exist in the table");
            else {
//                get index of key
                int index = getIndex(key);
                table.set(index, null);
            }
        }
    }
}