package org.example;

public class StringHash implements Hash<String> {
    public StringHash(boolean NMethod){

    }

    public StringHash() {

    }

    @Override
    public void insert(String key) {

    }

    @Override
    public void delete(String key) {
        System.out.println("pp");
    }

    @Override
    public boolean search(String key) {
        return false;
    }

    @Override
    public void batchInsert(String path) {

    }

    @Override
    public void batchDelete(String path) {

    }
}
