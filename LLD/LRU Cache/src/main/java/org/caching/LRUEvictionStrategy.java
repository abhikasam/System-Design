package org.caching;

import java.util.LinkedHashSet;

public class LRUEvictionStrategy<K> implements IEvictionStrategy<K> {
    private final LinkedHashSet<K> lruCache;
    public LRUEvictionStrategy(){
        this.lruCache = new LinkedHashSet<>();
    }

    @Override
    public void onAccess(K key) {
        lruCache.remove(key);
        lruCache.addFirst(key);
    }

    @Override
    public void onPut(K key) {
        lruCache.addFirst(key);
    }

    @Override
    public void onRemove(K key) {
        lruCache.remove(key);
    }

    @Override
    public K evict() {
        if(lruCache.isEmpty()) return null;
        K next = lruCache.getLast();
        if(next!=null)
            lruCache.remove(next);
        return next;
    }

    @Override
    public String toString() {
        return "LRUEvictionStrategy{" +
                "lruCache=" + lruCache +
                '}';
    }
}
