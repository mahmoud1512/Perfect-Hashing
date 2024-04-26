package org.example;

import java.util.ArrayList;

public interface Hash<T> {
    Boolean insert(T key);
    Boolean delete(T key);
    Boolean search(T key);
    int[] batchInsert(ArrayList<T> keys);
    int[] batchDelete(ArrayList<T> keys);
}
