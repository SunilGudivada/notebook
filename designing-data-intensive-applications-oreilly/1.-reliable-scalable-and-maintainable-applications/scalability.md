---
description: Measuring load & Performance latency, percentiles throughput
---

# Scalability

Scalability is the _**system's ability to cope with the increasing load**_. However, that is not a one-dimensional label that we can attach to a system: it is meaningless to say "_X is scalable?_" or "_Y doesn't scale ?_". It means considering questions like "If the system grows in a particular way, what are our options for coping with the growth?" and "How can we add computing resources to handle the additional load ?".

### Describing the Load

The Load can be described with a few numbers which are called _Load parameters._  It mainly depends on the architecture of the system.&#x20;

* It may be requested per second to a web server
* The ratio of reads to writes in a database.
* The number of simultaneously active users in a chat room.
* The hit rate on a cache.

### Twitter Case Study

{% hint style="warning" %}
**Data Reference:** [https://www.infoq.com/presentations/Twitter-Timeline-Scalability/](https://www.infoq.com/presentations/Twitter-Timeline-Scalability/)
{% endhint %}

The main operations involved in Twitter are as follows:

* Post Tweet
* Home Timeline

**Post Tweet**: Users can publish a message to all their followers. `4.6k requests` on average over `12k requests/sec` at peak.

**Home Timeline:** A user can view tweets posted by the people they follow (`300k requests/sec`).

Twitter's scaling challenge is not primarily due to tweet volume, but due to [**Fan-out**](https://en.wikipedia.org/wiki/Fan-out) ( Each user follows many people, and each user is followed by many people). There are two ways of implementing these two operations:

1. Posting a tweet simply inserts the new tweet into a global collection of tweets. When a user requests their home timeline, look up all the people they follow, find all the tweets for each of those users, and merge them ( Sorted by time ).

![](<../../.gitbook/assets/image (77).png>)

```sql
SELECT tweets.*, users.* 
FROM tweets 
JOIN users ON tweets.sender_id = users.id
JOIN follows ON follows.followee_id = users.id
WHERE follows.follower_id = {current_user_id}
```

&#x20;2\. Maintain a cache for each user's home timeline - like a mailbox of tweets for each recipient user. when a user posts a tweet, look up all the people who follow that user, and insert the new tweet into each of their home timeline caches. The request to read the home timeline is then cheap because its result has been computed ahead of time.&#x20;

![](<../../.gitbook/assets/image (140).png>)

Twitter came with `approach 1` and then they moved to `approach 2`. `Approach 2` works better because the average rate of published tweets is almost two orders of magnitude lower than the rate of home timelines reads, and so in this case it's preferable to do more work at write time and less at reading time. On the other hand in `approach 2`, posting a tweet now requires a lot of extra work.&#x20;

Now Twitter is moving to a hybrid approach.  Users with a very large number of followers are expected from this fan-out. Tweets from any celebrities that a user may follow are fetched separately and merged with that user's home timeline when it is read, like in approach 1.

### Describing Performance

Once you have enough load into the system, we have to look into how our system performs.

1. When you increase a load parameter and keep the system resources (CPU, memory, network bandwidth, etc..) unchanged, how is the performance of your system getting affected?
2. When you increase a load parameter, how much do you need to increase the resources if you want to keep performance unchanged?

For Both questions, we require performance numbers. In Online systems, What is usually more important is the services response time i.e.., the time between a client sending a request and receiving a response.&#x20;

{% hint style="info" %}
&#x20;**Latency and response time**_:_ These two words are often used as synonyms, but they are not the same. Response time is what the client sees: besides the actual time to process a request(_service time),_ it includes network delays and queuing delays. Latency is the duration that a request is waiting to be handled - during which it is _latent,_ awaiting service.
{% endhint %}

Response time can vary a lot, therefore it's important to think of response time not as a single value, but as a distribution of values. Even in a scenario where you'd think all requests should take the same time, you get variation: random additional latency could be introduced by a context switch on the background process, loss of a network packet and TCP retransmission, a garbage collection pause, etc.

The Average Response time of a service is often reported but it is not a very good metric if you want to know your "typical" response time, because it doesn't tell you how many users actually experienced that delay. A better approach is to use _percentiles._

### **Percentiles**

Median is a good metric to know how long users are typically waiting for the response. If half of the requests are served less than the median and another half in more than the median response time then it is called _50th Percentile_.&#x20;

{% hint style="danger" %}
&#x20;Median refers to the single request. If the user makes several requests, the probability that at least one of them is slower than the median is much greater than 50%
{% endhint %}

High percentiles of responses are also known as _tail latencies._ These percentiles directly affect the customers. Cloud services like google, amazon have very high latencies around _99.9th percentile_ which means 1 in 1000 requests are getting affected. on the other hand, optimizing the 99.99th percentile ( 1 in 10,000 requests )was deemed too expensive and do not yield enough benefit for their purposes. Reducing response times at very high percentiles is difficult because they are easily affected by random events outside of your control, and the benefits are diminishing.

<mark style="color:purple;background-color:purple;">Percentiles are often used in SLOs (Service Level Objectives) and SLAs (Service Level Agreements). They set the expectations of a user, and a refund may be demanded if the expectation is not met.</mark>

The Server sometimes processes only a limited number of requests based on the CPU cores. And it takes only a small number of slow requests to hold up the processing of subsequent requests sometimes it is called the _head of line blocking_. Due to this effect, it is important to measure response times on the client side. Basically, requests could be fast individually but one slow request could slow down all the other requests.

It takes just one slow call to make the entire end-user request slow - _Tail latency amplification._

{% hint style="info" %}
Averaging percentiles is useless, the right way of aggregating response time data is by adding histograms.
{% endhint %}

### **Approaches coping with load**
