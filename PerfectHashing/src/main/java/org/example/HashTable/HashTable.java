package org.example.HashTable;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<T>{
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

    protected Integer getStatus(T key){
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
}
