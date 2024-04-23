package org.example.HashTable;

import java.util.ArrayList;
import java.util.Collections;

public class HashTable<T>{
//    hash function of hash table
    protected HashFunction<T> hashFunction;
//    size of hash table (based on type of hash)
    protected int hashTableSize = 16;
//    construct default hash table
    protected ArrayList<T> table;
    protected int numberOfRehash = 0;

//    construct default table
    protected void initializeHashTable(int numberOfMaxKeyBits) {
        table = new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
//        initialize hash function
        hashFunction = new HashFunction<>(numberOfMaxKeyBits);
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log(hashTableSize * hashTableSize / Math.log(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();
    }

//    construct custom table
    protected void initializeHashTable(int numberOfMaxKeyBits, int hashTableSize) {
        this.hashTableSize = hashTableSize;
        table = new ArrayList<>(Collections.nCopies(hashTableSize * hashTableSize, null));
//        initialize hash function
        hashFunction = new HashFunction<>(numberOfMaxKeyBits);
        hashFunction.setNumberOfIndexBits((int)Math.floor(Math.log(hashTableSize * hashTableSize / Math.log(2))));
//        construct hash matrix
        hashFunction.createHashMatrix();
    }
}
