package org.example.HashTable;

import java.util.ArrayList;

public class HashTable<T>{
//    hash function of hash table
    protected HashFunction hashFunction;
//    hash table
    protected ArrayList<T> table;
//    size of hash table (based on type of hash)
    protected int hashTableSize;
    protected int numberOfRehash;
}
