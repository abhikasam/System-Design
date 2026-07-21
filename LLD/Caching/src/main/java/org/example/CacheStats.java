package org.example;

import java.util.concurrent.atomic.LongAdder;

public class CacheStats {
    private final LongAdder hits;
    private final LongAdder misses;
    private final LongAdder evictions;

    public CacheStats(){
        this.hits = new LongAdder();
        this.misses = new LongAdder();
        this.evictions = new LongAdder();
    }

    public void recordHit(){
        this.hits.increment();
    }

    public void recordMiss(){
        this.misses.increment();
    }

    public void recordEviction(){
        this.evictions.increment();
    }

    public long getHits() {
        return this.hits.sum();
    }
}
