package org.example;

public interface IEvictionStrategy<K> {
    void onAccess(K key);
    void onPut(K key);
    void onRemove(K key);
    K evict();
}
