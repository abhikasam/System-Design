package org.example;

public interface ICachePolicy {
    void update(int key,int value);
    int get(int key);
}
