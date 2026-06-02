package org.example;

public class Cache {
    private final ICachePolicy cachePolicy;

    Cache(int capacity){
        this.cachePolicy = new LFUCachePolicy(capacity);
    }

    public void put(int key, int value){
        this.cachePolicy.update(key,value);
    }

    public int get(int key){
        return this.cachePolicy.get(key);
    }

    @Override
    public String toString() {
        return cachePolicy.toString();
    }
}
