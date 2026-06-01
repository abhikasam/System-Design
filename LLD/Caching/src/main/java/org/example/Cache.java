package org.example;

public class Cache {
    ICachePolicy cachePolicy;

    Cache(int capacity){
        this.cachePolicy = new LRUPolicy(capacity);
    }

    void put(int key,int value){
        cachePolicy.update(key,value);
    }

    int get(int key){
        return cachePolicy.retrieve(key);
    }
}
