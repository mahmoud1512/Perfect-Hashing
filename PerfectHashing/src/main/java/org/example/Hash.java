package org.example;

import java.util.ArrayList;

public interface Hash<T> {
    void insert(T key);
    void delete(T key);
    int search(T key);
    void batchInsert(String path);
    void batchDelete(String path);
}
