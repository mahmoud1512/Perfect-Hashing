package org.example.Methods;

import org.example.Hash;
import org.example.HashTable.HashFunction;
import org.example.HashTable.HashTable;

import java.util.ArrayList;
import java.util.Collections;

public class NSquareSpace<T> extends HashTable<T> implements Hash<T> {

    public NSquareSpace(int numberOfMaxKeyBits) {
        table = new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
//        initialize hash function
        hashFunction = new HashFunction<>(numberOfMaxKeyBits);
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log(hashTableSize * hashTableSize / Math.log(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();
    }

    public NSquareSpace(int numberOfMaxKeyBits, int hashTableSize) {
        this.hashTableSize = hashTableSize;
        table = new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
//        initialize hash function
        hashFunction = new HashFunction<>(numberOfMaxKeyBits);
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log(hashTableSize * hashTableSize / Math.log(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();
    }

    protected ArrayList<T> getKeys(){
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

    public int getSize(){
        return hashTableSize * hashTableSize;
    }

    @Override
    public Boolean insert(T key) {
//        get index of key
        int index = getIndex(key);
//        empty bucket (insert)
        if(getStatus(key) == -1) {
            table.set(index, key);
            return true;
        }
//        same index and same key (warning message)
        else if(getStatus(key) == 1){
            return false;
        }
//        same index and different key (rehash)
        else{
//            get keys from old hash table
            ArrayList<T> arrayOfKeys = getKeys();
            arrayOfKeys.add(key);
//            resize and rehash
            rehash(arrayOfKeys);
        }
        return true;
    }

    @Override
    public Boolean delete(T key) {
//        empty bucket || same index and different key (warning message)
        if(getStatus(key) == -1 || getStatus(key) == 0) {
            return false;
        }
//        same index and same key (delete)
        else{
//            get index of key
            int index = getIndex(key);

            table.set(index, null);
        }
        return true;
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
