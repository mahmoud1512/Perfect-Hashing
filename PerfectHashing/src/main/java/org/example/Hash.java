package org.example;

import java.util.ArrayList;

public interface Hash<T> {
    void insert(T key);
    void delete(T key);
    int search(T key);
    void batchInsert(ArrayList<T> keys);
    void batchDelete(ArrayList<T> keys);
}
