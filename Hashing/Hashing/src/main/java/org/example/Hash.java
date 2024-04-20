package org.example;

public interface Hash<T> {
    void insert(T key);
    void delete(T key);
    boolean search(T key);
    void batchInsert(String path);
    void batchDelete(String path);
}
