package org.example;

import java.util.HashMap;
import java.util.Map;

public class LRUPolicy implements ICachePolicy {
    DoubleLinkedList doubleLinkedList;
    Map<Integer,DLLNode> map;
    int capacity;

    LRUPolicy(int capacity){
        this.capacity = capacity;
        this.doubleLinkedList = new DoubleLinkedList();
        this.map = new HashMap<>();
    }

    @Override
    public void update(int key,int value) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            node.val = value;
            doubleLinkedList.remove(node);
            doubleLinkedList.moveToFront(node);
        }
        else {
            if(map.size() == capacity){
                DLLNode last = doubleLinkedList.removeLast();
                map.remove(last.key);
            }
            DLLNode node = new DLLNode(key,value);
            doubleLinkedList.addFirst(node);
            map.put(key,node);
        }
    }

    @Override
    public int retrieve(int key) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            doubleLinkedList.moveToFront(node);
            return node.key;
        }
        return -1;
    }

    @Override
    public String toString(){
        return doubleLinkedList.toString();
    }
}
