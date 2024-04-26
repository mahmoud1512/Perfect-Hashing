package org.example.HashTable;

import org.example.Hash;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HashTable<T> implements Hash<T> {
//    hash function of hash table
    protected HashFunction<T> hashFunction;
//    size of hash table (based on type of hash)
    protected int hashTableSize = 16;
//    construct default hash table
    protected ArrayList<T> table;
    protected int numberOfRehash = 0;

    protected int getIndex(T key) {
//        convert to binary array
        ArrayList<Integer> binaryKeyArray = hashFunction.convertToBinaryArray(key);
//        hash matrix * binaryKeyArray
        return hashFunction.multiplication(binaryKeyArray);
    }

    public int getHashTableSize() {
        return hashTableSize;
    }

    @Override
    public Boolean insert(T key) {
        return null;
    }

    @Override
    public Boolean delete(T key) {

        return null;
    }

    @Override
    public Boolean search(T key) {
        return null;
    }

    @Override
    public int[] batchInsert(ArrayList<T> keys) {
        return new int[0];
    }

    @Override
    public int[] batchDelete(ArrayList<T> keys) {
        return new int[0];
    }
}
