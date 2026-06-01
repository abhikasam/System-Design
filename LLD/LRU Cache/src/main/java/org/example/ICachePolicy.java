package org.example;

public interface ICachePolicy {
    void update(int key,int node);
    int retrieve(int key);
}
