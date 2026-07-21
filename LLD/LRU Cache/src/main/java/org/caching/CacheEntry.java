package org.caching;

public class CacheEntry<V> {
    private final V value;
    private final long expiresAt;
    CacheEntry(V value,long ttl){
        this.value = value;
        this.expiresAt = ttl > 0 ? System.currentTimeMillis() + ttl : Long.MAX_VALUE;
    }

    V getValue(){
        return value;
    }

    boolean isExpired(){
        return System.currentTimeMillis() > expiresAt;
    }
}
