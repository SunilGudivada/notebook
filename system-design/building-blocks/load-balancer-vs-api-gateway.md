---
cover: >-
  https://images.unsplash.com/photo-1520502547463-27df7d9edcaa?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHw2fHxsb2FkfGVufDB8fHx8MTcyMzExMDY3MXww&ixlib=rb-4.0.3&q=85
coverY: 0
---

# 🔹 Load Balancer Vs API Gateway

In the high-level overview of the system design, both these blocks look the same. But they are not. Let me tell you.&#x20;



Imagine you organized the big party and had the different food counters. Assume Pizza counter is one of them. At t0, you have one pizza counter in the food arena. Over the time more audience start reaching the party, and you added the one more pizza counter to the food arena. During the peek time more people started eating pizza now you pizza counter owner can't control the crowd and keeps one person near the counters and redirects to the people to the counter having the less number of people.&#x20;

Now lets see  the balcony view, pizza owner what he did was he identified the increase in the load increased the number of orders and number of people staying in the queue. Now he assigned one balancer to distribute the load based on the queue size in the respective counter.&#x20;



**Different Techniques with respect to the pizza counter:**

1.  **Round Robin -** The balancer sends each new guest to the next counter in a cyclic order, without considering the current queue length.

    \
    **Analogy with Pizza counter**: If there are three counters, the first guest goes to Counter 1, the second to Counter 2, the third to Counter 3, and the fourth back to Counter 1.\

2.  **Least Connections -**The balancer sends new guests to the counter with the fewest people currently in the queue.

    \
    **Analogy with Pizza counter**: If Counter 1 has 3 people, Counter 2 has 2, and Counter 3 has 1, the next guest will be directed to Counter 3.\

3.  **Least Response Time**- The balancer sends guests to the counter that is currently serving people the fastest, indicating it can handle more load quickly.

    \
    **Analogy with Pizza counter**: If Counter 1 typically serves a pizza in 2 minutes, Counter 2 in 3 minutes, and Counter 3 in 1 minute, the balancer will prioritize Counter 3 for new guests.\

4.  **IP Hash -** Each guest has a unique identifier, and the balancer always directs the same guest to the same counter based on this identifier.

    \
    **Analogy with Pizza counter**: If a guest's identifier (like a name tag) hashes to Counter 2, they will always be directed to Counter 2 whenever they return for more pizza.\

5.  **Weighted Round Robin-** Some counters are more capable (larger staff or faster ovens) and can handle more guests, so the balancer sends more guests to these counters based on their capacity.

    \
    **Analogy with Pizza counter**: If Counter 1 can handle twice as many orders as Counter 2, the balancer will send two guests to Counter 1 for every one guest sent to Counter 2.\

6.  **Weighted Least Connections  -** The balancer sends guests to the counter with the fewest people, but also considers the capacity of each counter.

    \
    **Analogy with Pizza counter**: If Counter 1 (higher capacity) has 5 people, Counter 2 (lower capacity) has 3 people, and Counter 3 (medium capacity) has 2 people, the balancer may still direct guests to Counter 3 based on its capacity to handle more load efficiently\


**Key features:**&#x20;

* **Traffic Distribution**: Balances traffic across multiple servers.
* **Scalability**: Helps scale horizontally by adding more servers.
* **High Availability**: Increases availability by routing traffic to healthy servers.
* **Health Checks**: Monitors the health of servers and directs traffic to healthy ones.

{% hint style="info" %}
Operates at Transport layer and application layer ( Layer 4 and Layer 7 ) of the OSI Model
{% endhint %}



Now let's look into the api gateway.

Imagine you want to order the items required for a big party like pizza, ballons, cakes. Instead of you calling all the stores for the items. Find one person who can do all the stuff for you and they will handle everything  for you. That special guy is like the **api gateway.** An API Gateway is a helper that takes all the requests from people (like ordering party supplies) and sends them to the right places.

**Key Features:**

* **Request Routing**: Routes API requests to appropriate microservices.
* **Protocol Translation**: Translates protocols (e.g., HTTP to WebSocket).
* **Authentication and Authorization**: Enforces security policies for incoming requests.
* **Rate Limiting and Throttling**: Controls the rate of requests to prevent abuse.
* **Caching**: Provides caching capabilities to improve performance.
* **Analytics and Monitoring**: Offers detailed logging and monitoring of API usage.

{% hint style="info" %}
Operates primarily at Layer 7 (Application) of the OSI model.
{% endhint %}

Let me add all the differences in the table for you, \


| Feature                            | Load Balancer                                                 | API Gateway                                  |
| ---------------------------------- | ------------------------------------------------------------- | -------------------------------------------- |
| **Primary Function**               | Distributes traffic to multiple servers                       | Manages and routes API requests              |
| **Layer of Operation**             | Layer 4 (Transport) and Layer 7 (Application)                 | Layer 7 (Application)                        |
| **Traffic Distribution**           | Yes                                                           | No                                           |
| **Request Routing**                | Basic routing                                                 | Advanced routing based on API endpoints      |
| **Protocol Translation**           | No                                                            | Yes                                          |
| **Authentication & Authorization** | No                                                            | Yes                                          |
| **Rate Limiting & Throttling**     | No                                                            | Yes                                          |
| **Caching**                        | Limited                                                       | Yes                                          |
| **Health Checks**                  | Yes                                                           | No                                           |
| **SSL Termination**                | Yes                                                           | Yes                                          |
| **Session Persistence**            | Yes                                                           | No                                           |
| **Scalability**                    | Horizontal scaling by adding more servers                     | Facilitates scaling by managing API traffic  |
| **High Availability**              | Yes                                                           | Yes                                          |
| **Analytics & Monitoring**         | Basic (server health, traffic distribution)                   | Detailed (API usage, performance metrics)    |
| **Complexity**                     | Generally simpler                                             | More complex                                 |
| **Use Case Context**               | General traffic distribution for web servers, databases, etc. | Specifically for microservices architectures |
