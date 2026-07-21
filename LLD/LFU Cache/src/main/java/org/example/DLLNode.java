package org.example;

public class DLLNode {
    int key;
    int value;
    int frequency;
    DLLNode prev;
    DLLNode next;
    DLLNode(){}
    DLLNode(int key,int value){
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }

    @Override
    public String toString(){
        return "["+key+":"+value+"]->"+next;
    }
}
