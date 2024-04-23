package org.example;

import org.example.HashTable.HashFunction;
import org.example.HashTable.HashTable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class NSpaceHash<T> extends HashTable<T> implements Hash<T>{


    NSpaceHash(int maxKeyBits, int hashTableSize) {
        this.hashTableSize = hashTableSize;

        table = (ArrayList<T>) new ArrayList<>(Collections.nCopies(hashTableSize, new IntegerHash<>(32, 1)));
        hashFunction = new HashFunction();
        hashFunction.setNumberOfMaxKeyBits(maxKeyBits);
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log10(hashTableSize / Math.log10(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();
    }

    @Override
    public void insert(T key) {
        int index = getIndex(key);
        ((IntegerHash) table.get(index)).insert(key);
    }

    @Override
    public void delete(T key) {
        int index = getIndex(key);
        ((IntegerHash) table.get(index)).delete(key);
    }

    @Override
    public int search(T key) {
        int index = getIndex(key);
        return ((IntegerHash) table.get(index)).search(key);
    }

    @Override
    public void batchInsert(String path) {
        ArrayList<T> keys = readFromFile(path);
        //ArrayList<T> distinct = new ArrayList<>();
        for(T key: keys){
            if(search(key) == 1){
                System.out.println("element " + key + " is already exist");
            }
            else {
                insert(key);
            }
        }
    }

    @Override
    public void batchDelete(String path) {
        ArrayList<T> keys = readFromFile(path);
        for(T key: keys){
            if(search(key) == -1 || search(key) == 0)
                System.out.println("The element " + key + " already does not exist in the table");
            else {
                delete(key);
            }
        }
    }

    public static void main(String[] args) {

    }
}
