package org.example.Methods;

import org.example.Hash;
import org.example.HashTable.HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class NSquare<T> extends HashTable<T> implements Hash<T> {

    public NSquare(int numberOfMaxKeyBits) {
        initializeHashTable(numberOfMaxKeyBits);
    }

    public NSquare(int numberOfMaxKeyBits, int hashTableSize) {
        initializeHashTable(numberOfMaxKeyBits, hashTableSize);
    }
    private int getIndex(T key) {
//        convert to binary array
        ArrayList<Integer> binaryKeyArray = hashFunction.convertToBinaryArray(key);
//        hash matrix * binaryKeyArray
        return hashFunction.multiplication(binaryKeyArray);
    }

    private ArrayList<T> getKeys(){
        ArrayList<T> keys = new ArrayList<>();
        for(T key : table) {
            if(key != null)
                keys.add(key);
        }
        return keys;
    }

    private Integer getStatus(T key){
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
//        same index and different key
        else {
            return 0;
        }
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
            if(getStatus(key) == 0) {
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
        if(getStatus(key) == -1) {
            table.set(index, key);
        }
//        same index and same key (warning message)
        else if(getStatus(key) == 1){
            System.out.println("The element you need to insert is already exist");
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
        if(getStatus(key) == -1 || getStatus(key) == 0) {
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
    public Boolean search(T key) {

        return getStatus(key) == 1;
    }

    @Override
    public int[] batchInsert(ArrayList<T> keys) {
        ArrayList<T> distinct = new ArrayList<>();
        int [] insertStatus = new int[2];
        for(T key: keys){
            if(getStatus(key) == 1){
//                count exist keys
                insertStatus[0]++;
            }
            else if(!distinct.contains(key)){
                distinct.add(key);
            }
        }
//        inserted keys
        insertStatus[1] = distinct.size();
        for(T key: table){
            if(key != null)
                distinct.add(key);
        }
        rehash(distinct);

        return insertStatus;
    }

    @Override
    public int [] batchDelete(ArrayList<T> keys) {
        int [] deleteStatus = new int[2];
        for(T key: keys){
            if(getStatus(key) == -1 || getStatus(key) == 0)
//                count not exist keys
                deleteStatus[0]++;
            else {
//                get index of key
                int index = getIndex(key);
                table.set(index, null);
//                count deleted keys
                deleteStatus[1]++;
            }
        }
        return deleteStatus;
    }
}
