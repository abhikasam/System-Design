InMemoryCache with eviction strategy
provided cache stats
cache entry maintains ttl where we can also check if a key is expired.

cache eviction with lazy loading, check if expired and then return null.

LRU Cache → use LinkedHashSet → add First for insertion, get last for removing.

LFU Cache → use counts and timestamps, for same count use the least timestamp it accessed.

ReentrantReadWriteLock → to make sure no two edits happen at the same time.