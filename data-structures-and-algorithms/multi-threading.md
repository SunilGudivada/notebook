---
coverY: 0
---

# Introduction

**Why MultiThreading?**&#x20;

* Better CPU Utilization
* Better IO Utilization
* Higher application responses

**Issues with Multi-Threading:**

****

**Shared Mutable State issues:**

* Race Conditions
* Invisible Writes
* Congestion
* DeadLock
* Nested Monitor Lockout
* Starvation
* Slipped Condition
* Missed Signals

**No Shared Mutable state concurrency:**

* Separate State Concurrency
* Functional Paralleism
*   Parallel Pipelines



**Multi-Threading Costs:**

****

****



| Type                               | Use Case                                                                                                                                                       |
| ---------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Volatile                           | Flags                                                                                                                                                          |
| <p>AtomicInteger<br>AtomicLong</p> | Counters                                                                                                                                                       |
| AtomicReference                    | <ol><li>Caches (Building new cache in the background and replacing atomically)</li><li>Used By some internal classes</li><li>Non Blocking Algorithms</li></ol> |





**Reference Links**

[http://tutorials.jenkov.com/java-concurrency/index.html](http://tutorials.jenkov.com/java-concurrency/index.html)[https://www.interviewbit.com/multithreading-interview-questions/\
https://leetcode.com/problemset/concurrency/\
https://www.educative.io/courses/java-multithreading-for-senior-engineering-interviews\
https://www.youtube.com/c/DefogTech\
https://www.cs.bham.ac.uk/\~szh/teaching/ssc/lecturenotes/Concurrency/Tutorial\_Week9.pdf](https://www.interviewbit.com/multithreading-interview-questions/https://leetcode.com/problemset/concurrency/https://www.educative.io/courses/java-multithreading-for-senior-engineering-interviewshttps://www.youtube.com/c/DefogTechhttps://www.cs.bham.ac.uk/\~szh/teaching/ssc/lecturenotes/Concurrency/Tutorial\_Week9.pdf)
