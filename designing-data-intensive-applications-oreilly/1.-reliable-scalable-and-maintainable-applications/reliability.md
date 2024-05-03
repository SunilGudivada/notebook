---
description: Tolerating hardware & software faults human error
---

# Reliability

For Software, typical expectations include:&#x20;

* The application performs the function that the user expected
* It can tolerate the user making mistakes or using the software in unexpected ways
* Its performance is good enough for the required use case, under the expected load and data volume
* The system prevents any unauthorized access and abuse

> **Continuing to work correctly, even when things go wrong.**

#### **Fault VS Failure**

_A Fault is not the same as failure_. The things that can go wrong are _**faults**_. and systems that anticipate faults and can cope with them are called _**fault-tolerant or resilient.**_ A **fault** is usually defined as one component of the system deviating from its spec, whereas a **failure** is when the system as a whole stops proving the required service to the user.&#x20;

It's impossible to reduce the probability of faults to zero, thus, it's useful to design fault-tolerance mechanisms that prevent faults from causing failures.

{% hint style="info" %}
**Fault-Tolerant System:**

The Netflix Simian Army - [https://netflixtechblog.com/the-netflix-simian-army-16e57fbab116](https://netflixtechblog.com/the-netflix-simian-army-16e57fbab116)&#x20;
{% endhint %}

### **Hardware Faults** <a href="#id-5a1a" id="id-5a1a"></a>

The Disk may be set up in a [**RAID configuration**](https://en.wikipedia.org/wiki/RAID), servers may have dual power supplies and hot-swappable CPU's and data centers may have batteries and diesel generators for backup power. When one component dies, the redundant component can take its place while the broken component is replaced.&#x20;

As data volumes and applications' computing demands have increased, there's been a shift towards using software fault-tolerance techniques in preference or in addition to hardware redundancy. An advantage of these software fault-tolerant systems is that: For a single server system, it requires planned downtime if the machine needs to be rebooted (e.g. to apply operating system security patches). However, for a system that can tolerate machine failure, it can be patched one node at a time (without the downtime of the entire system - a _rolling upgrade)_

### **Software Errors**

Software failures are more correlated than hardware failures. There is no quick solution to the problem of systematic faults in the software. Below are things that can help.

* Carefully thinking about the assumptions and interactions in the system.
* Thorough testing
* Process isolation
* Allowing the process to crash and restart
* Measuring, Monitoring, and analyzing system behavior in production.

### Human Errors

Humans are unreliable.&#x20;

#### How do we make our system reliable, in spite of unreliable humans?

* Design Systems in a way that minimizes the opportunities for error. For example, well-designed abstractions, APIs, and admin interfaces make it easy to do "the right thing" and discourage "the wrong thing." However, if the interfaces are too restrictive people will work around them, negating their benefits, so this is the tricky balance to get right.
* Decouple the places where people make the most mistakes from the places where they can cause failures. In particular, provide fully featured non-production sandbox environments where people can explore and experiment safely, using real data, without affecting the real users.
* Test thoroughly at all levels, from unit tests to whole system integrations tests and manual tests. Automated testing is widely used, well understood, and especially valuable for covering corner cases that rarely arise in normal operation.&#x20;
* Allow quick and easy recovery from human errors, to minimize the impact in the case of a failure. For instance, make it fast to roll back configuration changes, roll our new code gradually and provide the tools to recompute the data if required.
* Setup detailed and clear monitoring such as performance metrics and error rates.

We have a responsibility to our users, and hence reliability is very important. There are situations in which we may choose to sacrifice reliability in order to reduce development costs or operational costs.
