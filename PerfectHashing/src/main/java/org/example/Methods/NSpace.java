package org.example.Methods;

import org.example.Hash;
import org.example.HashTable.HashFunction;
import org.example.HashTable.HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class NSpace<T> extends HashTable<T> implements Hash<T> {

    private final int numberOfMaxKeyBits;
    private int numberOfElements = 0;

    public NSpace(int numberOfMaxKeyBits, int hashTableSize) {
        this.hashTableSize = hashTableSize;

        this.numberOfMaxKeyBits = numberOfMaxKeyBits;

//        initialize hash function
        hashFunction = new HashFunction<>(numberOfMaxKeyBits);
        table = new ArrayList<>(Collections.nCopies(hashTableSize, null));
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log(hashTableSize / Math.log(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();

    }

    public int getNumberOfRehash(){
        int numberOfRehash = 0;
        for (int i = 0; i < hashTableSize; i++){
            if (!Objects.equals(table.get(i), null))
                numberOfRehash += ((NSquareSpace<T>) table.get(i)).getNumberOfRehash();
        }
        return numberOfRehash;
    }



    public int getSize(){
        int size = 0;
        for (int i = 0; i < hashTableSize; i++){
            if (!Objects.equals(table.get(i), null))
                size += ((NSquareSpace<T>) table.get(i)).getSize();
            else
                size++;
        }
        return size;
    }

    public ArrayList<T> getElements(){
        ArrayList<T> keys = new ArrayList<>();
        for (int i = 0; i < hashTableSize; i++){
            if(!Objects.equals(table.get(i), null)){
                keys.addAll(((NSquareSpace<T>) table.get(i)).getKeys());
            }
        }
        return keys;
    }

    private void fullRehash(ArrayList<T> keys){
        hashTableSize = keys.size() * 5;

        table = new ArrayList<>(Collections.nCopies(hashTableSize, null));
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log(hashTableSize / Math.log(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();
//        insert elements
        batchInsert(keys);
    }

    private boolean checkDynamicRehash(){
        float loadFactor = 0.5f;
        return ((((float)numberOfElements) / (float) hashTableSize) >= loadFactor);
    }

    @Override
    public Boolean insert(T key) {
        if (checkDynamicRehash()){
//            get elements from table
            ArrayList<T> keys = getElements();
            keys.add(key);
            numberOfElements = 0;
            numberOfRehash++;
//            full rehash;
            fullRehash(keys);
            return true;
        }
        int index = getIndex(key);
        if(Objects.equals(table.get(index), null)){
            table.set(index, (T) new NSquareSpace<>(numberOfMaxKeyBits, 2));
        }
        if(((NSquareSpace<T>) table.get(index)).insert(key)) {
            numberOfElements++;
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(T key) {
        int index = getIndex(key);
        if (!Objects.equals(table.get(index), null)) {
            if (((NSquareSpace<T>) table.get(index)).delete(key)) {
                numberOfElements--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean search(T key) {
        int index = getIndex(key);
        if (!Objects.equals(table.get(index), null))
            return ((NSquareSpace<T>) table.get(index)).search(key);
        return false;
    }

    @Override
    public int[] batchInsert(ArrayList<T> keys) {
        int [] insertionStatus = new int[2];
        for(T key: keys){
            if(search(key)){
//                count exist keys
                insertionStatus[0]++;
            }
            else {
//                count inserted keys
                insertionStatus[1]++;
                numberOfElements++;
                insert(key);
            }
        }
        return insertionStatus;
    }

    @Override
    public int[] batchDelete(ArrayList<T> keys) {
        int [] deleteStatus = new int[2];
        for(T key: keys){
            if(search(key)) {
//                count deleted keys
                deleteStatus[0]++;
                numberOfElements--;
                delete(key);
            }
            else {
//                count non exist keys
                deleteStatus[1]++;
            }
        }
        return deleteStatus;
    }
}
