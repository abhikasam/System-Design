package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Cache cache = new Cache(3);
        cache.put(1,6);
        cache.put(2,4);
        System.out.println("cache so far:\n"+cache);
        cache.put(2,5);
        System.out.println("cache so far:\n"+cache);
        cache.put(3,5);
        System.out.println("cache so far:\n"+cache);
        cache.put(4,6);
        System.out.println("cache so far:\n"+cache);
        cache.put(4,7);
        System.out.println("cache so far:\n"+cache);
        cache.put(2,8);
        System.out.println("cache so far:\n"+cache);
        cache.put(5,1);
        System.out.println("cache so far:\n"+cache);
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println("cache so far:\n"+cache);
    }
}
