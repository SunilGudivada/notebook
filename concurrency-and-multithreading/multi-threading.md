---
coverY: 0
---

# Introduction

**Why MultiThreading?**&#x20;

* Better CPU Utilization
* Better IO Utilization
* Higher application responses

## Issues with Multi-Threading

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
* Parallel Pipelines

## **Multi-Threading Costs:**

* **More Complex Design** - Code executed by multiple threads accessing shared data need special attention. Thread interaction is far from always simple. Errors arising from incorrect thread synchronization can be very hard to detect, reproduce and fix.
* **Context Switching Overhead** - When a CPU switches from executing one thread to executing another, the CPU needs to save the local data, program pointer, etc. of the current thread, and load the local data, program pointer, etc. of the next thread to execute. This switch is called a "context switch". The CPU switches from executing in the context of one thread to executing in the context of another.
* **Increased resource consumption** - Threads needs some memory to maintain its local stack it consumes more resources inside OS. &#x20;

## **Appendix:**

<table><thead><tr><th width="212.10526315789474">Type</th><th>Use Case</th></tr></thead><tbody><tr><td>Volatile</td><td>Flags</td></tr><tr><td>AtomicInteger<br>AtomicLong</td><td>Counters</td></tr><tr><td>AtomicReference</td><td><ol><li>Caches (Building new cache in the background and replacing atomically)</li><li>Used By some internal classes</li><li>Non Blocking Algorithms</li></ol></td></tr></tbody></table>





