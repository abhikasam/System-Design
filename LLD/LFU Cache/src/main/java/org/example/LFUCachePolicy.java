package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCachePolicy implements ICachePolicy {
    Map<Integer,DLLNode> keyMap;
    TreeMap<Integer,DoubleLinkedList> freqMap;
    int capacity;

    LFUCachePolicy(int capacity){
        this.keyMap = new HashMap<>();
        this.freqMap = new TreeMap<>();
        this.capacity = capacity;
    }

    public void update(int key, int value){
        if(capacity==0)
            return;
        if(keyMap.containsKey(key)){
            DLLNode dllNode = keyMap.get(key);
            dllNode.value = value;
            updateDllNodeFrequency(dllNode);
        }
        else{
            if(keyMap.size()==capacity){
                Map.Entry<Integer,DoubleLinkedList> entry = freqMap.firstEntry();
                int frequency = entry.getKey();
                DoubleLinkedList dll = entry.getValue();
                DLLNode dllNode = dll.removeLast();
                if(dll.isEmpty()) freqMap.remove(frequency);
                keyMap.remove(dllNode.key);
            }
            DoubleLinkedList doubleLinkedList = freqMap.computeIfAbsent(1,
                    a-> new DoubleLinkedList());
            DLLNode dllNode = new DLLNode(key,value);
            doubleLinkedList.addFirst(dllNode);
            keyMap.put(key,dllNode);
        }
    }

    public int get(int key){
        if(!keyMap.containsKey(key)) return -1;
        DLLNode dllNode = keyMap.get(key);
        updateDllNodeFrequency(dllNode);
        return dllNode.value;
    }

    void updateDllNodeFrequency(DLLNode dllNode){
        DoubleLinkedList oldDll = freqMap.get(dllNode.frequency);
        oldDll.remove(dllNode);
        if(oldDll.isEmpty())
            freqMap.remove(dllNode.frequency);
        dllNode.frequency++;
        DoubleLinkedList newDll = freqMap.computeIfAbsent(dllNode.frequency,
                a-> new DoubleLinkedList());
        newDll.addFirst(dllNode);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,DoubleLinkedList> entry : freqMap.entrySet()){
            sb.append("{").append(entry.getKey()).append("}=>(").append(entry.getValue()).append(")\n");
        }
        return sb.toString();
    }


}
