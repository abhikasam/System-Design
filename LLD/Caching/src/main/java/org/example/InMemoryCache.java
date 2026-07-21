package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InMemoryCache<K,V> {
    private final IEvictionStrategy<K> evictionStrategy;
    private final int capacity;
    private final Map<K,CacheEntry<V>> store;
    private final CacheStats cacheStats;
    private final ReentrantReadWriteLock readWriteLock;
    public InMemoryCache(int capacity,IEvictionStrategy<K> evictionStrategy){
        this.evictionStrategy = evictionStrategy;
        this.capacity = capacity;
        this.store = new HashMap<>();
        this.cacheStats = new CacheStats();
        this.readWriteLock = new ReentrantReadWriteLock();
    }

    V get(K key){
        readWriteLock.writeLock().lock();
        try{
            CacheEntry<V> entry = store.get(key);
            if(entry==null){
                cacheStats.recordMiss();
                return null;
            }
            if(entry.isExpired()){
                store.remove(key);
                evictionStrategy.onRemove(key);
                cacheStats.recordMiss();
                return null;
            }
            evictionStrategy.onAccess(key);
            cacheStats.recordHit();
            return entry.getValue();
        }
        finally {
            readWriteLock.writeLock().unlock();
        }
    }

    void put(K key, V value,long ttl){
        readWriteLock.writeLock().lock();
        try{
            CacheEntry<V> entry = store.get(key);
            if(entry!=null) {
                store.put(key, new CacheEntry<>(value,ttl));
                evictionStrategy.onAccess(key);
            }
            else {
                if(store.size()==capacity){
                    K evictedKey = evictionStrategy.evict();
                    if(evictedKey!=null){
                        store.remove(evictedKey);
                        cacheStats.recordEviction();
                    }
                }
                store.put(key, new CacheEntry<>(value,ttl));
                evictionStrategy.onPut(key);
           }
        }
        finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public String toString() {
        return "InMemoryCache{" +
                "evictionStrategy=" + evictionStrategy +
                '}';
    }
}
