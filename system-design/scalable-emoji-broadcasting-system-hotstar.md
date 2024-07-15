---
description: >-
  Hotstar first introduced Sports Bar in 2019. In the world cup 2019, 5 Billion
  Emojis from 55.83 Million users during the ICC Cricket World Cup 2019.
cover: ../.gitbook/assets/1_kIzYvy84FsMGW4UUlaYjXw.webp
coverY: 0
---

# 🏏 Scalable Emoji Broadcasting System - Hotstar

Hotstar main aim was to convert the sounds and responses in the live cricket ground. These are nothing but audience reactions in a digital way of expressing emotions. Showing the mood of the audience and displaying the changing moods in real-time is challenging when you plan to receive billions of such emoji submissions during a tournament.



### **Key Design Principles**&#x20;

**Scalability**: Increase the resources with increase in traffic. Hotstar achieved this by using the horizontal scaling with load balancers  and auto scaling of the resources configured

**Decomposition**: Breaking into small components and each being allowed to do the particular task independent of each other. &#x20;

**Asynchronous:** Process execution should not block the resources and provides high concurrency.&#x20;



### **Envelope Calculations**

Assume the scenario of World cup 2019, Target was to scale upto 5 Billion Emojis from 55.83 Million users over 48 Matches.&#x20;

Total users would be around 55.83 Million users, lets do some assumption by considering 20% of the total users are active. So the number of concurrent users are 0.2 \* 55.83 which is around 11.166 Million users.

Now let's do some calculations on the emojis.&#x20;

Total Emojis received: 5 Billions

Average Emoji's Per Match: 5,000,000,000 / 48 \~ 104166667 emojis per match.

{% hint style="info" %}
Each match duration is 3 hours
{% endhint %}

Number of Emojis per hour:  104166667 / 3 = 34722222.3

Number of Emojis per second: 34722222.3 / 3600 = 9645.06175 \~ 9646 emojis per second



### **Storage Calculations**

Now lets calculate the size of the emoji data we need to store:&#x20;

```json
{
  "emoji_id": "a32cb3ad-b7ad-4b38-b213-84a9c6365aca",
  "user_id": "62c9fdb6-c833-4cce-a2fa-faddefa36a69",
  "timestamp": "2024-07-15T12:34:56Z",
  "emoji_type": "animation",
  "message_id": "c2459179-4585-4f7a-b287-1e52ecf895cf",
  "recipient_id": "5bd0f171-862a-4ed9-9f3a-523314ae7598",
  "channel_id": "b8f8d727-b29e-4ac6-aac4-6224e4c91c35",
  "event_id": "b029d956-98da-4109-8334-4515d9e81214",
  "metadata": {
    "reaction": "cheer",
    "emotion": "happy"
  }
}

```

Size of the emoji data is 230 B

Total Emojis per second: 9646

Total increase in memory size per second: 9646 \* 230 = 2218580 Bytes = 2.21 MB

Every match we need almost 2.21 \* 3600 \* 3 = 23.89 GB of data

Entire World it needs 23.89 \* 48 = 1146.72 GB \~ 1.2 TB

For the world cup total data for the emojis would be around 1.2 TB

### Functional Requirements

1. Users can browse and select stickers during live cricket matches found in the **sports bar**.
2. Stickers can be sent over a live&#x20;
3. Stickers appear instantly in the live chat interface.

### Non-Functional Requirements

1. High availability to support concurrent users during peak traffic.
2. Low latency for real-time sticker delivery.
3. Secure transmission and storage of sticker data.
4. Scalable infrastructure to accommodate increasing user base and traffic.

### **System Components**

{% content-ref url="system-design-component-checklist/" %}
[system-design-component-checklist](system-design-component-checklist/)
{% endcontent-ref %}

_Hotstar defined the technologies in the blog mentioned in the references:_

{% embed url="https://blog.hotstar.com/capturing-a-billion-emojis-62114cc0b440" %}

<figure><img src="../.gitbook/assets/Hot star Emoji - System Design.png" alt=""><figcaption><p>Scalable Emoji Broadcasting system, world cup - Hotstar</p></figcaption></figure>

* [ ] **Client Side Components:**
  * **HTTP API**: Clients send user-submitted emojis via HTTP requests.
  * **Local Buffer**: To handle asynchronous message sending.\

* [ ] **Service Side Components:**&#x20;
  * **Golang Producer**: Handles asynchronous message production to Kafka using Goroutines and Channels.
  * **Python Consumer**: Consumes processed data from Kafka and normalizes it.\

* [ ] **Databases:** The system primarily relies on Kafka for message queuing and PubSub for data delivery and NoSql to store the user profile information and subscriptions.\

* [ ] **Cache:** Not required, since the data to be handled in the real time\

* [ ] **Load Balancers:** Distribute incoming API requests across multiple servers for horizontal scalability\

* [ ] **Message Queues:**&#x20;
  * **Kafka**: Used for high throughput, availability, and low latency message queuing.
  * **Knol**: Hotstar's data platform built on Kafka.\

* [ ] **API Gateways:**&#x20;
  * **HTTP API Gateway**: Manages incoming API requests from clients\

* [ ] **Configuration Management:**
  * **Configuration Files**: Used in Golang producer and Spark streaming jobs for flush intervals, batch durations, etc.\

* [ ] **Monitoring and Logging:**
  * **Monitoring Tools**: Likely in place to monitor the health and performance of Kafka, Spark jobs, and PubSub.
  * **Logging**: Implemented in Golang producer, Kafka, and PubSub for debugging and auditing purposes.\

* [ ] **Authentication and Authorization**
  * **API Security**: Ensure secure client-server communication.
  * **Access Control**: Managed for Kafka, PubSub, and other internal components.\

* [ ] **Scalability and Reliability:**
  * **Horizontal Scalability**: Achieved with load balancers and auto-scaling mechanisms.
  * **Reliability**: Ensured through Kafka's fault-tolerance and replication features.\

* [ ] **Networking:**
  * **Internal Network**: Ensures secure communication between various components (API gateway, Kafka, Spark, PubSub).
  * **External Network**: Handles client interactions securely\

* [ ] **DevOps and CI/CD**
  * **CI/CD Pipeline**: Automates testing, deployment, and updates for various components (Golang producer, Spark jobs).
  * **Infrastructure as Code**: Manages infrastructure deployment and scaling.\

* [ ] **Analytics and Reporting**
  * **Real-Time Metrics**: Captured by Spark jobs and monitored by internal tools.
  * **Usage Statistics**: Analyzed to measure user engagement and system performance.\

* [ ] &#x20;**Data Processing**
  * **Spark Streaming**: Processes and aggregates data in real-time.
  * **Golang Producer**: Manages asynchronous message production.
  * **Kafka Consumer**: Normalizes data and sends it to PubSub.

<figure><img src="../.gitbook/assets/image (149).png" alt=""><figcaption></figcaption></figure>

### **References**

[https://blog.hotstar.com/capturing-a-billion-emojis-62114cc0b440](https://blog.hotstar.com/capturing-a-billion-emojis-62114cc0b440)\
[https://blog.hotstar.com/building-pubsub-for-50m-concurrent-socket-connections-5506e3c3dabf](https://blog.hotstar.com/building-pubsub-for-50m-concurrent-socket-connections-5506e3c3dabf)\
[https://blog.scottlogic.com/2018/04/17/comparing-big-data-messaging.html](https://blog.scottlogic.com/2018/04/17/comparing-big-data-messaging.html)\
[https://blog.hotstar.com/data-democratisation-hotstar-93ebfb1e688d](https://blog.hotstar.com/data-democratisation-hotstar-93ebfb1e688d)\
[https://medium.com/@chandanbaranwal/spark-streaming-vs-flink-vs-storm-vs-kafka-streams-vs-samza-choose-your-stream-processing-91ea3f04675b](https://medium.com/@chandanbaranwal/spark-streaming-vs-flink-vs-storm-vs-kafka-streams-vs-samza-choose-your-stream-processing-91ea3f04675b)\
[https://www.debugbear.com/json-size-analyzer](https://www.debugbear.com/json-size-analyzer)\
[https://blog.hotstar.com/hotstars-journey-from-ec2-to-containers-86ea4e4880fd](https://blog.hotstar.com/hotstars-journey-from-ec2-to-containers-86ea4e4880fd)\
[https://newsletter.systemdesign.one/p/hotstar-architecture](https://newsletter.systemdesign.one/p/hotstar-architecture)\
