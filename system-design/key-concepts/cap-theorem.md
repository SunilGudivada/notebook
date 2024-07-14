---
cover: >-
  https://images.unsplash.com/photo-1516397281156-ca07cf9746fc?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHw1fHxvbmxpbmV8ZW58MHx8fHwxNzIwOTYwNTA2fDA&ixlib=rb-4.0.3&q=85
coverY: 0
---

# 🌐 CAP Theorem

In very simple words,&#x20;

* **Consistency**: Every read receives the most recent write or an error.
* **Availability**: All reads contain data, but it might not be the most recent.
* **Partition tolerance**: The system continues to operate despite network failures.

<figure><img src="../../.gitbook/assets/image.png" alt=""><figcaption><p>Source: Wikipedia</p></figcaption></figure>

In practice, distributed systems must choose which two out of the three properties they will guarantee:

*   <mark style="color:purple;">**CP (Consistency and Partition Tolerance)**</mark><mark style="color:purple;">:</mark> The system remains consistent and tolerates network partitions, but might not be available during a partition.

    **Example**: HBase, MongoDB in certain configurations, Banking Systems\

*   <mark style="color:purple;">**AP (Availability and Partition Tolerance)**</mark><mark style="color:purple;">:</mark> The system remains available and tolerates network partitions, but might return outdated data during a partition.

    **Example**: Cassandra, Couchbase, Social media platforms\

*   <mark style="color:purple;">**CA (Consistency and Availability)**</mark><mark style="color:purple;">:</mark> The system remains consistent and available as long as there are no network partitions.

    **Example**: Relational databases in a single-node setup or systems within a single data center without network partitions.

MongoDB can be configured to satisfy all the above three different implications (CP, AP, CA)&#x20;

1. **Consistency and Partition Tolerance (CP) Configuration**:
   * **Replica Sets**: MongoDB uses replica sets to ensure data is replicated across multiple nodes. By default, MongoDB is designed to provide strong consistency.
   * **Write Concerns**: You can configure write concerns to ensure that writes are acknowledged by a majority of the nodes, ensuring strong consistency even in the presence of network partitions.
   * **Read Preferences**: Setting read preferences to "primary" ensures that all reads are directed to the primary node, which holds the most recent data.
   * **Trade-off**: This configuration might compromise availability because if the primary node is unavailable or there's a network partition, writes cannot be acknowledged until a new primary is elected.\

2. **Availability and Partition Tolerance (AP) Configuration**:
   * **Replica Sets**: MongoDB's replica sets can also be configured to prioritize availability.
   * **Write Concerns**: Using lower write concerns (e.g., `w: 1`) ensures that writes are acknowledged as soon as they are written to the primary node, which increases availability but might compromise consistency during network partitions.
   * **Read Preferences**: Setting read preferences to "secondary" or "nearest" allows reads from secondary nodes, which might return slightly stale data but ensures high availability.
   * **Trade-off**: This configuration might compromise consistency because reads might not always reflect the most recent writes, especially during network partitions.\

3. **Consistency and Availability (CA) Configuration** (Less Typical for Distributed Systems):
   * This configuration is less typical for MongoDB in a distributed setup because achieving CA requires no network partitions, which is unrealistic in most distributed systems.
   * In a single-node MongoDB setup or within a single data center with highly reliable networking, MongoDB can effectively provide CA guarantees.
   * **Trade-off**: This setup sacrifices partition tolerance, meaning it won't handle network partitions gracefully.



**References:**&#x20;

[https://en.wikipedia.org/wiki/CAP\_theorem](https://en.wikipedia.org/wiki/CAP\_theorem)\
