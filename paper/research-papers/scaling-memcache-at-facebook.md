---
cover: >-
  https://images.unsplash.com/photo-1611162618071-b39a2ec055fb?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHwyfHxmYWNlYm9va3xlbnwwfHx8fDE3MTk0OTczNjZ8MA&ixlib=rb-4.0.3&q=85
coverY: 0
---

# Scaling Memcache at Facebook



*   **Enhancements to Memcached**:

    * **Lease Mechanism**: To mitigate the "thundering herd" problem, a lease mechanism is used. When a cache miss occurs, a lease token is assigned to one server, preventing multiple servers from simultaneously querying the backend database.
    * **Adaptive Slab Allocator**: This helps in better memory management by reducing fragmentation and optimizing memory allocation for different sizes of data​.


*   **Handling Consistency and Stale Data**:

    * **McSqueal and Mcrouter**: These tools are used to ensure data consistency across different regions by broadcasting invalidations whenever the data is updated in the database​.
    * **Replication and Invalidation**: SQL statements modifying data include the required cache keys, ensuring that updates are propagated to all relevant caches​.


*   **Scaling Strategies**:

    * **Regional Clusters**: Splitting servers into regional clusters reduces latency and improves reliability by keeping data closer to users and mitigating the effects of large-scale outages​.
    * **Different Pools for Different Data Types**: Assigning different pools to different types of data based on access patterns and memory requirements prevents negative interactions and optimizes performance​.


*   **Load Balancing and Failure Handling**:

    * **Gutter Servers**: These are used as fallback when primary memcached servers fail, preventing cascading failures that can overload the system​​.
    * **Distributed Read Requests**: Read requests are distributed across multiple replicas to balance the load and improve performance​.


* **Performance Optimization**:
  * **Eviction Policies**: Utilizing Least Recently Used (LRU) eviction policies within each slab class ensures efficient memory use by discarding the least used items first​.
  * **High Availability**: The design incorporates mechanisms to handle server failures gracefully, ensuring high availability and reliability of the caching system​​.
