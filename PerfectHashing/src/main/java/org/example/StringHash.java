//package org.example;
//
//import org.example.HashTable.HashFunction;
//import org.example.HashTable.HashTable;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Objects;
//
//public class StringHash extends HashTable<String> implements Hash<String> {
//    public StringHash() {
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
//        hashFunction.setNumberOfMaxKeyBits(80);
//        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log10(hashTableSize * hashTableSize / Math.log10(2))));
////        construct hash matrix
//        hashFunction.createHashMatrix();
//    }
//
//    //      convert float to binary string
//    private String convertToBinary(String key){
////        convert each char to its ASCII and convert the ASCII to binary
////        StringBuilder binaryStringBuilder = new StringBuilder();
////        char[] charArray = key.toCharArray();
////        for (char c : charArray) {
////            // Convert each character to its ASCII value
////            // Convert the ASCII value to binary representation
////            String binaryValue = Integer.toBinaryString((int) c);
////            // Pad the binary representation with leading zeros if necessary
////            String paddedBinaryValue = String.format("%8s", binaryValue).replace(' ', '0');
////            // Append the binary representation to the StringBuilder
////            binaryStringBuilder.append(paddedBinaryValue);
////        }
////        return binaryStringBuilder.toString();
//
////        multiply each char by its index and convert to binary
//        int sum = 0;
//        for (int i = 0; i < key.length(); i++) {
//            char c = key.charAt(i);
//            // Multiply the character value by its index and add to sum
//            sum += (i + 1) * (int) c;
//        }
//        // Convert the sum to binary representation
//        return Integer.toBinaryString(sum);
//    }
//
//    private int getIndex(String key) {
////        convert to binary
//        String binaryKeyString = convertToBinary(key);
////        convert to binary array
//        ArrayList<Integer> binaryKeyArray = hashFunction.convertToBinaryArray(binaryKeyString);
////        hash matrix * binaryKeyArray
//        return hashFunction.multiplication(binaryKeyArray);
//    }
//
//    private ArrayList<String> getKeys(){
//        ArrayList<String> keys = new ArrayList<>();
//        for(String key : table) {
//            if(key != null)
//                keys.add(key);
//        }
//        return keys;
//    }
//
//    private void rehash(ArrayList<String> arrayOfKeys){ // recursion function
//        numberOfRehash++;
//        hashTableSize = arrayOfKeys.size();
//        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log10(hashTableSize * hashTableSize) / Math.log10(2)));
////        resize
//        table= new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
////        rehash
//        hashFunction.createHashMatrix();
//
//        for(String key: arrayOfKeys){
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
//    public void insert(String key) {
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
//            ArrayList<String> arrayOfKeys = getKeys();
//            arrayOfKeys.add(key);
////            resize and rehash
//            rehash(arrayOfKeys);
//        }
//    }
//
//    @Override
//    public void delete(String key) {
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
//    public int search(String key) {
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
//    public void batchInsert(ArrayList<String> keys) {
//        ArrayList<String> distinct = new ArrayList<>();
//        for(String key: keys){
//            if(search(key) == 1){
//                System.out.println("element " + key + " is already exist");
//            }
//            else if(!distinct.contains(key)){
//                distinct.add(key);
//            }
//        }
//        for(String key: table){
//            if(key != null)
//                distinct.add(key);
//        }
//        rehash(distinct);
//    }
//
//    @Override
//    public void batchDelete(ArrayList<String> keys) {
//        for(String key: keys){
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
