package org.example;

import java.util.HashMap;
import java.util.Map;

public class DoubleLinkedList {
    DLLNode head;
    DLLNode tail;

    DoubleLinkedList(){
        this.head = new DLLNode();
        this.tail = new DLLNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    void addFirst(DLLNode node){
        DLLNode next = this.head.next;
        this.head.next = node;
        node.next = next;
        node.prev = this.head;
        next.prev = node;
    }

    DLLNode removeLast(){
        if(isEmpty()) return null;
        DLLNode curr = this.tail.prev;
        curr.prev.next = this.tail;
        curr.next.prev = curr.prev;
        return curr;
    }

    void remove(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    boolean isEmpty(){
        return this.head.next == this.tail && this.tail.prev == this.head;
    }

    @Override
    public String toString(){
        return this.head.toString();
    }

}
