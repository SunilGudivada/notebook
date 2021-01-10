---
description: 'Priority: P1'
---

# Concurrency and Multithreading

## Concurrency and Multithreading

Multithreading deserves its own category. If direct questions on this topic - like "_How is a mutex different from a semaphore?_ 🤔 " - usually not set, then all the same streams, and all with These related things pop out in many areas, from algorithms to system design. Sometimes interviewers after you have written the solution to the problem, they may ask "_How would you make your code thread safe?_ 🤔 "So do not be lazy and study this topic thoroughly.

### What you need to know

1. Working with streams in your programming language - libraries, classes and their features. 
2. Basic concepts - threads, processes, mutexes, context switch, deadlock, race condition.
3. Data synchronization between streams - what are the features, what needs to be addressed Attention.
4. Testing multi-threaded programs, the main signs of bugs associated with multithreading.
5. Try to write your own mutex class and / or shared pointer.

### Books

* \*\*\*\*["C ++ Concurrency in Action: Practical Multithreading"](http://amzn.to/2cQfJlY)
* ["Java Concurrency in Practice" ](https://www.amazon.com/gp/product/0321349601/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&tag=everydaymat0e-20&camp=1789&creative=9325&linkCode=as2&creativeASIN=0321349601&linkId=895d239c548b52e09fee67ed45863ecd)
* [The Art of Multiprocessor Programming](https://www.amazon.com/Art-Multiprocessor-Programming-Revised-Reprint/dp/0123973376)

### Links and Articles

* [Concurrency and multithreading interview questions](https://www.cs.bham.ac.uk/~szh/teaching/ssc/lecturenotes/Concurrency/Tutorial_Week9.pdf)
* [the Processes and-Forums Threads from A. The Tannenbaum \(one of my favorite authors in CS\)](https://users.soe.ucsc.edu/~sbrandt/111/Slides/chapter2.pdf)

## Design, large-scale systems

Priority: the P1

Questions about the design of large distributed systems. The main "problem" of such questions is that they often don't have the "right" answer. They are specially tailored to find the weak links in your knowledge, and preparing for such questions is, to some extent, trying to cover immense, especially if you have no experience with large systems.

These questions can start off harmlessly. For example: “_You have an application that you written in one person on your computer, the code is stored simply on your hard drive, and your computer stores all data and the application itself. Suddenly, your app is being bought and used by other people and you have ten users already. What do you need to do to to ensure that the program works for users? What changes when you have a hundred users? ... So, now you have a thousand users, and you've earned 10 thousand dollars. How is your architecture and / or infrastructure changing? And now you have 10 thousand users and you earned 100 thousand dollars ... And now you have 100 thousand users and you earned $ 1 million ..._ "

Keep in mind that if you are tempted to say, “I sell the business, take the money and shed enjoy life under a palm tree to the Canary Islands ", it won't help you, it doesn't matter to answer the questions have to =\). This also includes questions about performance optimization, application stability, [CAP theorem](https://en.wikipedia.org/wiki/CAP_theorem) , etc.

The good news for us is that you don't have to spend years learning all the details. network protocols, memory architecture, etc. . There is a fairly limited \(albeit rather big\) a set of techniques and approaches that you just need to learn:

1. **Scaling** . It is important to understand here that the plug most often occurs in a relational database, as possible This can be avoided by sharding or by using various NoSQL like MongoDB.
2. At the level of service you can talk about **load balancing** and some of its strategies. Any the system should load the servers more or less evenly.
3. **Fail-safe** \(aka eliminate single point of failure, aka consistency\). Anyone you draw on

   the chalkboard architecture for solving the issue must allow any of its parts to fail Anytime. Here you can additionally tell about Netflix chaos monkey and how cool it is 😀 

4. **Replication** Any stateful service, any part of the system must allow reboot and failure at any time. To do this, you need the data to be at this time  available elsewhere.
5. **Master selection**  If you can tell in detail about the leader selection algorithm when failures and recoveries, such as Raft or Paxos, then consider that interviews passed.
6. **Performance** \(usually about caching and load balancing\), tell several load strategies  balancing and about different levels of cache, tell about Memcached or Redis, and examples of them use in practice, talk about geographic load balancing, synchronization data between multiple datacenters.
7. A very important part of distributed systems is the **exchange of messages and the logging** , so a practical acquaintance with RabbitMQ, Amazon SQS / SNS, Kafka will help a lot.
8. Also remember about the **monitoring system** . What data do you want to measure and what the criteria for the "health" of the system you choose?
9. **Deployment** . Docker containers, managing them with mesos, problems deployment of distributed systems can also come in handy.

### Books

[Distributed Systems: Principles and Paradigms](http://amzn.to/2cLu0gp)

### Links and Articles

* [Scalable Web Architecture and Distributed Systems](http://www.aosabook.org/en/distsys.html)
* [The System Design for Tech Interviews](https://www.hiredintech.com/courses/system-design) - useful because there is an example of a question, a reference to a lecture from Harvard and links to how actual product designs are made. Of this the material should definitely be enough for those who have 5 or less years of experience. For the more experienced candidates need to be digged deeper, but this is also a good start.
* [The System Design](https://www.interviewbit.com/courses/system-design/) on Interviewbit
* Questions about system architecture \([part](https://translate.google.com/translate?hl=en&prev=_t&sl=ru&tl=en&u=http://larrr.com/voprosy-na-arhitekturu-sistem-chast-1/) 1, [Part](https://translate.google.com/translate?hl=en&prev=_t&sl=ru&tl=en&u=http://larrr.com/voprosy-na-arhitekturu-sistem-chast-2/) 2\)
* http://highscalability.com/
* https://github.com/checkcheckzz/system-design-interview
* http://blog.gainlo.co/index.php/category/system-design-interview-questions/ - also examples questions. Quite simple, but maybe it will be useful at the initial level too.

