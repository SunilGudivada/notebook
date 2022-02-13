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

Twitter's scaling challenge is not primarily due to tweet volume, but due to **** [**Fan-out**](https://en.wikipedia.org/wiki/Fan-out) ( Each user follows many people, and each user is followed by many people). There are two ways of implementing these two operations:

1. Posting a tweet simply inserts the new tweet into a global collection of tweets. When a user requests their home timeline, look up all the people they follow, find all the tweets for each of those users, and merge them ( Sorted by time ).

![](<../../.gitbook/assets/image (113).png>)

```sql
SELECT tweets.*, users.* 
FROM tweets 
JOIN users ON tweets.sender_id = users.id
JOIN follows ON follows.followee_id = users.id
WHERE follows.follower_id = {current_user_id}
```

&#x20;2\. Maintain a cache for each user's home timeline - like a mailbox of tweets for each recipient user. when a user posts a tweet, look up all the people who follow that user, and insert the new tweet into each of their home timeline caches. The request to read the home timeline is then cheap because its result has been computed ahead of time.&#x20;

![](<../../.gitbook/assets/image (114).png>)

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

