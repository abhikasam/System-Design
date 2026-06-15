package org.caching;

public class Main {
    static void main(String[] args){
        InMemoryCache<Integer,Integer> memoryCache = new InMemoryCache<>(5,new LRUEvictionStrategy<>());
        System.out.println(memoryCache.get(4));
        memoryCache.put(4,7,0);
        memoryCache.put(5,9,0);
        memoryCache.put(2,9,0);
        memoryCache.put(3,9,0);
        memoryCache.put(1,9,0);
        System.out.println(memoryCache.get(4));
        System.out.println(memoryCache);
        System.out.println(memoryCache.get(5));
        System.out.println(memoryCache);
        memoryCache.put(6,0,4);
        System.out.println(memoryCache);

        memoryCache = new InMemoryCache<>(5,new LFUEvictionStrategy<>());
        System.out.println(memoryCache.get(5));
        memoryCache.put(4,7,0);
        memoryCache.put(5,9,0);
        memoryCache.put(2,9,0);
        memoryCache.put(3,9,0);
        memoryCache.put(1,9,0);
        System.out.println(memoryCache.get(4));
        System.out.println(memoryCache);
        System.out.println(memoryCache.get(5));
        System.out.println(memoryCache);
        memoryCache.put(6,0,4);
        System.out.println(memoryCache);
        memoryCache.put(7,5,0);
        System.out.println(memoryCache);
    }
}
