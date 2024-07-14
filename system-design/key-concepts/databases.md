---
cover: >-
  https://images.unsplash.com/photo-1498050108023-c5249f4df085?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHwyfHxzeXN0ZW18ZW58MHx8fHwxNzIwOTYwNDQzfDA&ixlib=rb-4.0.3&q=85
coverY: 0
---

# 🌐 Databases

1.  **PostgreSQL**:

    **Concepts and Features**:

    * **Relational Database**: PostgreSQL is a powerful open-source relational database management system (RDBMS) known for its reliability, robustness, and support for ACID (Atomicity, Consistency, Isolation, Durability) transactions.
    * **Data Types**: PostgreSQL supports a wide range of data types, including numeric, string, date/time, JSON, and custom user-defined types.
    * **Indexing**: PostgreSQL provides various indexing techniques, including B-tree, hash, and Generalized Inverted Index (GIN), to optimize query performance.
    * **Advanced Features**: PostgreSQL offers advanced features such as full-text search, geospatial support (PostGIS extension), and support for JSONB (binary JSON) data type for efficient storage and querying of JSON documents.
    * **Extensibility**: PostgreSQL allows users to define custom functions, data types, and procedural languages (e.g., PL/pgSQL, PL/Python) to extend its functionality.


2.  **DynamoDB**:

    **Concepts and Features**:

    * **NoSQL Database**: DynamoDB is a fully managed NoSQL database service provided by AWS, designed for high availability, scalability, and low latency.
    * **Key-Value Store**: DynamoDB is a key-value and document database, where each item is identified by a unique primary key and can contain nested attributes and values.
    * **Scalability**: DynamoDB automatically scales to handle high volumes of traffic and storage requirements with no downtime or performance degradation.
    * **Consistency Models**: DynamoDB offers two consistency models: eventually consistent reads (default) and strongly consistent reads, allowing developers to choose the appropriate consistency level based on their application requirements.
    * **Secondary Indexes**: DynamoDB supports secondary indexes (global and local) to enable efficient querying of data based on attributes other than the primary key.
    * **DynamoDB Streams**: DynamoDB Streams allows capturing changes to data in real-time, enabling use cases such as data replication, stream processing, and triggering of AWS Lambda functions.


3.  **Redis**:

    **Concepts and Features**:

    * **In-Memory Data Store**: Redis is an open-source, in-memory data structure store known for its performance, versatility, and support for various data structures such as strings, hashes, lists, sets, and sorted sets.
    * **Persistence**: Redis supports different persistence options, including RDB (point-in-time snapshots) and AOF (append-only file), to ensure durability of data.
    * **Pub/Sub Messaging**: Redis provides built-in support for pub/sub messaging, allowing clients to subscribe to channels and receive messages published by other clients in real-time.
    * **Caching**: Redis is commonly used as a cache due to its fast read and write operations, support for data eviction policies, and ability to store frequently accessed data in memory.
    * **Advanced Features**: Redis offers advanced features such as transactions, Lua scripting, geospatial commands, and support for bitmaps and hyperloglogs.


4.  **Location Database** (e.g., MongoDB with geospatial indexes):

    **Concepts and Features**:

    * **Geospatial Indexing**: Location databases support indexing of geospatial data to efficiently query and analyze spatial information, such as points, lines, and polygons.
    * **Querying**: Location databases offer spatial query operators (e.g., $near, $geoWithin) to perform proximity searches, find points within a certain radius, or perform geometric operations on spatial data.
    * **Geospatial Data Types**: These databases support geospatial data types (e.g., GeoJSON) and geometric shapes (e.g., points, lines, polygons) to represent and manipulate spatial data.
    * **Use Cases**: Location databases are used in various applications, including mapping services, geolocation-based services, logistics and transportation, and location-based advertising.\

5.  **Time Series Database** (e.g., InfluxDB):

    **Concepts and Features**:

    * **Time Series Data Model**: Time series databases are optimized for storing and querying time-stamped data points, such as sensor readings, server metrics, financial data, and IoT data.
    * **Retention Policies**: Time series databases allow users to define retention policies to automatically expire or downsample data over time, helping manage storage costs and performance.
    * **Continuous Queries**: These databases support continuous queries to analyze and aggregate time series data in real-time, enabling monitoring, alerting, and anomaly detection.
    * **Compression and Downsampling**: Time series databases often use compression techniques and downsampling to reduce storage requirements and improve query performance for historical data.
    * **High Availability**: Time series databases are designed for high availability and scalability, with features such as clustering, replication, and sharding to handle large volumes of time series data.

Each of these databases and caches has its own strengths and use cases, and choosing the right one depends on the specific requirements of your application, including data model, scalability, performance, and consistency needs.



<figure><img src="../../.gitbook/assets/Group 5.png" alt=""><figcaption></figcaption></figure>



#### System Design Questions

1. **Design a URL Shortener**
   * How would you generate unique keys?
   * How would you handle collisions?
   * How would you ensure the scalability of the system?
2. **Design a Social Media Feed (e.g., Twitter, Facebook)**
   * How would you handle real-time updates and notifications?
   * How would you manage the database schema for user posts and comments?
   * How would you ensure scalability and load balancing?
3. **Design an E-commerce Website**
   * How would you manage the inventory and product catalog?
   * How would you handle transactions and payments?
   * How would you implement a recommendation system?
4. **Design a Chat Application (e.g., WhatsApp, Slack)**
   * How would you handle real-time messaging and notifications?
   * How would you ensure message delivery and read receipts?
   * How would you manage user authentication and authorization?
5. **Design a Web Crawler**
   * How would you manage the crawling process and handle duplicates?
   * How would you store and index the crawled data?
   * How would you ensure the crawler is efficient and doesn't overload servers?
6. **Design a Ride-Sharing Service (e.g., Uber, Lyft)**
   * How would you match drivers with riders in real-time?
   * How would you handle surge pricing and route optimization?
   * How would you ensure data consistency and fault tolerance?
7. **Design a Video Streaming Service (e.g., YouTube, Netflix)**
   * How would you handle video storage and encoding?
   * How would you manage user subscriptions and recommendations?
   * How would you ensure smooth streaming and handle buffering?
8. **Design a Search Engine**
   * How would you manage the indexing and ranking of web pages?
   * How would you handle user queries and return relevant results?
   * How would you ensure the search engine scales with increasing data?
9. **Design a Notification System**
   * How would you manage different types of notifications (e.g., email, SMS, push)?
   * How would you ensure timely delivery and retries in case of failures?
   * How would you handle user preferences and unsubscribes?
10. **Design a File Storage System (e.g., Dropbox, Google Drive)**
    * How would you handle file uploads, downloads, and synchronization?
    * How would you manage file metadata and sharing permissions?
    * How would you ensure data consistency and replication?
