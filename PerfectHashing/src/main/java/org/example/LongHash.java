//package org.example;
//
//import org.example.HashTable.HashFunction;
//import org.example.HashTable.HashTable;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Objects;
//
//public class LongHash extends HashTable<Long> implements Hash<Long> {
//
//    public LongHash() {
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
//        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log10(hashTableSize * hashTableSize / Math.log10(2))));
////        construct hash matrix
//        hashFunction.createHashMatrix();
//    }
//
//    //      convert float to binary string
//    private String convertToBinary(Long key){
//        return Long.toBinaryString(key);
//    }
//
//    private int getIndex(Long key) {
////        convert to binary
//        String binaryKeyString = convertToBinary(key);
////        convert to binary array
//        ArrayList<Integer> binaryKeyArray = hashFunction.convertToBinaryArray(binaryKeyString);
////        hash matrix * binaryKeyArray
//        return hashFunction.multiplication(binaryKeyArray);
//    }
//
//    private ArrayList<Long> getKeys(){
//        ArrayList<Long> keys = new ArrayList<>();
//        for(Long key : table) {
//            if(key != null)
//                keys.add(key);
//        }
//        return keys;
//    }
//
//    private void rehash(ArrayList<Long> arrayOfKeys){ // recursion function
//        numberOfRehash++;
//        hashTableSize = arrayOfKeys.size();
//        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log10(hashTableSize * hashTableSize) / Math.log10(2)));
////        resize
//        table= new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
////        rehash
//        hashFunction.createHashMatrix();
//
//        for(Long key: arrayOfKeys){
//            if(search(key) == 0) {
//                rehash(arrayOfKeys);
//            }
//            else{
////                get index of key
//                int index = getIndex(key);
//                table.set(index, key);
//            }
//        }
//    }
//
//    public int getNumberOfRehash(){
//        return numberOfRehash;
//    }
//
//    @Override
//    public void insert(Long key) {
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
//            ArrayList<Long> arrayOfKeys = getKeys();
//            arrayOfKeys.add(key);
////            resize and rehash
//            rehash(arrayOfKeys);
//        }
//    }
//
//    @Override
//    public void delete(Long key) {
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
//    public int search(Long key) {
//
////        get index of key
//        int index = getIndex(key);
//
////        empty bucket
//        if (Objects.equals(table.get(index), null)){
//            return -1;
//        }
////        same index and same key
//        else if (Objects.equals(key, table.get(index))){
//            return 1;
//        }
////        same index and different key
//        else {
//            return 0;
//        }
//    }
//
//    @Override
//    public void batchInsert(ArrayList<Long> keys) {
//        ArrayList<Long> distinct = new ArrayList<>();
//        for(Long key: keys){
//            if(search(key) == 1){
//                System.out.println("element " + key + " is already exist");
//            }
//            else if(!distinct.contains(key)){
//                distinct.add(key);
//            }
//        }
//        for(Long key: table){
//            if(key != null)
//                distinct.add(key);
//        }
//        rehash(distinct);
//    }
//
//    @Override
//    public void batchDelete(ArrayList<Long> keys) {
//        for(Long key: keys){
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
