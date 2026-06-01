package org.example;

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
        node.prev = this.head;
        node.next = next;
        next.prev = node;
    }

    void addLast(DLLNode node){
        DLLNode prev = this.tail.prev;
        this.tail.prev = node;
        node.next = this.tail;
        node.prev = prev;
        prev.next = node;
    }

    DLLNode removeFirst(){
        DLLNode curr = this.head.next;
        curr.next.prev = this.head;
        this.head.next = curr.next;
        return curr;
    }

    DLLNode removeLast(){
        DLLNode curr = this.tail.prev;
        curr.prev.next = this.tail;
        this.tail.prev = curr.prev;
        return curr;
    }

    void remove(DLLNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void moveToFront(DLLNode node){
        remove(node);
        addFirst(node);
    }

    @Override
    public String toString(){
        return this.head.toString();
    }
}
