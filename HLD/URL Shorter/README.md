### Functional Requirements
1. Long URL to short URL.
2. Redirect short URL to Long URL.
3. Short URLs should be unique.

#### Questions :
* Should the same long URL always return the same short URL on repeated requests, or is generating a new short URL each time acceptable? This decides whether I need a dedup lookup before creating a new mapping.
* Do we need to track usage — like click counts, timestamps, or referrer/geo data?
* Can users request a custom short URL, or all short URLs system-generated?
* Do short URLs expire by default, or do they live forever unless the user sets a TTL?

`For v1, functional requirements are: given a long URL, generate a short URL — same long URL always maps to the same short URL. Given a short URL, redirect to the original long URL. Users can optionally provide a custom alias. Short URLs can optionally have a TTL, no expiry by default. We track basic click analytics — count and timestamp. Mapping is immutable once created — no updates to the long URL behind an existing short URL.`

<hr/>

### Non Functional Requirements
1. Scalability - Horizontally scalable to support future growth.
2. Low latency - url shortening and redirects should happen in milliseconds.
3. Availability - system should redirect, even if any component fails.
4. Durability — once a short URL is created, the mapping should never be lost, system should work for years.
5. Security - malicious use prevention.

<hr/>

### Capacity Estimation
1. 1M new urls per day. ~12 urls per second.
2. 100:1 read:writes
3. Peak traffic : 10x
4. Max long url length : 100 characters.

#### Throughput
1. Avg : 12 writes/sec, 1200 reads/sec
2. Peak : 120 writes/second. 12000 reads/second

