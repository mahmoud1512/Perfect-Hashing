package org.example.Methods;

import org.example.Hash;
import org.example.HashTable.HashFunction;
import org.example.HashTable.HashTable;
import org.example.Methods.NSquareSpace;

import java.util.ArrayList;
import java.util.Collections;

public class NSpace<T> extends HashTable<T> implements Hash<T> {

    public NSpace(int numberOfMaxKeyBits, int hashTableSize) {
        this.hashTableSize = hashTableSize;
//        initialize hash function
        hashFunction = new HashFunction<>(numberOfMaxKeyBits);
        table = (ArrayList<T>) new ArrayList<>(Collections.nCopies(hashTableSize, new NSquareSpace<>(numberOfMaxKeyBits, 16)));
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log(hashTableSize / Math.log(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();

    }

    public int getNumberOfRehash(){
        int numberOfRehash = 0;
        for (int i = 0; i < hashTableSize; i++){
            numberOfRehash += ((NSquareSpace<T>) table.get(i)).getNumberOfRehash();
        }
        return numberOfRehash;
    }

    public int getSize(){
        int size = 0;
        for (int i = 0; i < hashTableSize; i++){
            size += ((NSquareSpace<T>) table.get(i)).getSize();
        }
        return size;
    }

    @Override
    public void insert(T key) {
        int index = getIndex(key);
        ((NSquareSpace<T>) table.get(index)).insert(key);
    }

    @Override
    public void delete(T key) {
        int index = getIndex(key);
        ((NSquareSpace<T>) table.get(index)).delete(key);
    }

    @Override
    public Boolean search(T key) {
        int index = getIndex(key);
        return ((NSquareSpace<T>) table.get(index)).search(key);
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
