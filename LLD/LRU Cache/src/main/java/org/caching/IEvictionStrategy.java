package org.caching;

public interface IEvictionStrategy<K> {
    void onAccess(K key);
    void onPut(K key);
    void onRemove(K key);
    K evict();
}
