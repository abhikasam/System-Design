package org.caching;

import java.util.HashMap;
import java.util.Map;

public class LFUEvictionStrategy<K> implements IEvictionStrategy<K> {
    private final Map<K,Integer> counts;
    private final Map<K,Long> timestamps;

    LFUEvictionStrategy(){
        this.counts = new HashMap<>();
        this.timestamps = new HashMap<>();
    }

    @Override
    public void onAccess(K key) {
        counts.merge(key,1,Integer::sum);
        timestamps.put(key,System.currentTimeMillis());
    }

    @Override
    public void onPut(K key) {
        counts.putIfAbsent(key,1);
        timestamps.put(key,System.currentTimeMillis());
    }

    @Override
    public void onRemove(K key) {
        counts.remove(key);
        timestamps.remove(key);
    }

    @Override
    public K evict() {
        K lfuKey = null;
        int minCount = Integer.MAX_VALUE;
        long minTimeStamp = Long.MAX_VALUE;

        for(Map.Entry<K,Integer> entry : counts.entrySet()){
            K key = entry.getKey();
            int count = entry.getValue();
            long times = timestamps.get(key);
            if(count < minCount || (count == minCount && times < minTimeStamp)){
                lfuKey = key;
                minCount = count;
                minTimeStamp = times;
            }
        }

        if(lfuKey!=null){
            counts.remove(lfuKey);
            timestamps.remove(lfuKey);
        }
        return lfuKey;
    }

    @Override
    public String toString() {
        return "LFUEvictionStrategy{" +
                "counts=" + counts +
                ", timestamps=" + timestamps +
                '}';
    }
}
