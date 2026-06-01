package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Cache cache = new Cache(5);
        System.out.println(cache.cachePolicy);
        cache.put(1,5);
        cache.put(2,7);
        cache.put(3,4);
        cache.put(4,9);
        cache.put(5,12);
        System.out.println(cache.cachePolicy);
        cache.put(3,6);
        System.out.println(cache.cachePolicy);
        cache.put(1,5);
        System.out.println(cache.cachePolicy);
        cache.get(6);
        System.out.println(cache.cachePolicy);
        cache.get(2);
        System.out.println(cache.cachePolicy);
    }
}
