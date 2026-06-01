package org.example;

public class DLLNode {
    int key;
    int val;
    DLLNode prev;
    DLLNode next;
    DLLNode(){}
    DLLNode(int key,int val){
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString(){
        return "["+key+":"+val+"]->"+next;
    }

}
