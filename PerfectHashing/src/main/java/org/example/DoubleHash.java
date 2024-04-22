//package org.example;
//
//import org.example.HashTable.HashFunction;
//import org.example.HashTable.HashTable;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Objects;
//
//public class DoubleHash extends HashTable<Double> implements Hash<Double> {
//    public DoubleHash() {
//        initialization();
//    }
//
//    private void initialization(){
//        numberOfRehash = 0;
////        default Size
//        hashTableSize = 16;
////        construct hash table
//        table = new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
////        ------------------------------------------------------------------------------------------------------------------
////        initialize hash function
//        hashFunction = new HashFunction();
//        hashFunction.setNumberOfMaxKeyBits(64);
//        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log(hashTableSize * hashTableSize / Math.log(2))));
////        construct hash matrix
//        hashFunction.createHashMatrix();
//    }
//
//    //      convert float to binary string
//    private String convertToBinary(Double key){
//        long longValue = Double.doubleToLongBits(key);
//        return Long.toBinaryString(longValue);
//    }
//
//    private int getIndex(Double key) {
////        convert to binary
//        String binaryKeyString = convertToBinary(key);
////        convert to binary array
//        ArrayList<Integer> binaryKeyArray = hashFunction.convertToBinaryArray(binaryKeyString);
////        hash matrix * binaryKeyArray
//        return hashFunction.multiplication(binaryKeyArray);
//    }
//
//    private ArrayList<Double> getKeys(){
//        ArrayList<Double> keys = new ArrayList<>();
//        for(Double key : table) {
//            if(key != null)
//                keys.add(key);
//        }
//        return keys;
//    }
//
//    private void rehash(ArrayList<Double> arrayOfKeys){ // recursion function
//        numberOfRehash++;
//        hashTableSize = arrayOfKeys.size();
//        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log10(hashTableSize * hashTableSize) / Math.log10(2)));
////        resize
//        table= new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
////        rehash
//        hashFunction.createHashMatrix();
//
//        for(Double key: arrayOfKeys){
//            if(search(key) == -1) {
////                get index of key
//                int index = getIndex(key);
//                table.set(index, key);
//            }
//            else{
//                rehash(arrayOfKeys);
//            }
//        }
//    }
//
//    public int getNumberOfRehash(){
//        return numberOfRehash;
//    }
//
//    @Override
//    public void insert(Double key) {
////        get index of key
//        int index = getIndex(key);
////        empty bucket (insert)
//        if(search(key) == -1) {
//            table.set(index, key);
//        }
////        same index and same key (warning message)
//        else if(search(key) == 1){
//            System.out.println("The integer you need to insert is already exist");
//        }
////        same index and different key (rehash)
//        else{
////            get keys from old hash table
//            ArrayList<Double> arrayOfKeys = getKeys();
//            arrayOfKeys.add(key);
////            resize and rehash
//            rehash(arrayOfKeys);
//        }
//    }
//
//    @Override
//    public void delete(Double key) {
////        empty bucket || same index and different key (warning message)
//        if(search(key) == -1 || search(key) == 0) {
//            System.out.println("The element is not exit to delete it!!!");
//        }
////        same index and same key (delete)
//        else{
////            get index of key
//            int index = getIndex(key);
//
//            table.set(index, null);
//        }
//    }
//
//    @Override
//    public int search(Double key) {
////        get index of key
//        int index = getIndex(key);
//
////        empty bucket
//        //    final int numberOfMaxKeyBits = 32;
//        long error = (long) 1e-10;
//        if (Objects.equals(table.get(index), null)){
//            return -1;
//        }
////        same index and same key
//        else if (Math.abs(key - table.get(index)) <= error){
//            return 1;
//        }
////        same index and different key
//        else {
//            return 0;
//        }
//    }
//
//    @Override
//    public void batchInsert(ArrayList<Double> keys) {
//        ArrayList<Double> distinct = new ArrayList<>();
//        for(Double key: keys){
//            if(search(key) == 1){
//                System.out.println("element " + key + " is already exist");
//            }
//            else if(!distinct.contains(key)){
//                distinct.add(key);
//            }
//        }
//        for(Double key: table){
//            if(key != null)
//                distinct.add(key);
//        }
//        rehash(distinct);
//    }
//
//    @Override
//    public void batchDelete(ArrayList<Double> keys) {
//        for(Double key: keys){
//            if(search(key) == -1 || search(key) == 0)
//                System.out.println("The element " + key + " already does not exist in the table");
//            else {
////                get index of key
//                int index = getIndex(key);
//                table.set(index, null);
//            }
//        }
//    }
//}
