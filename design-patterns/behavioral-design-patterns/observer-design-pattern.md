---
description: >-
  Define a one-to-many dependency between objects so that when one object
  changes state, all its dependents are notified and updated automatically.
---

# Observer Design Pattern

In this pattern, we call the publisher the **SUBJECT** and the subscribers the **OBSERVER**

{% hint style="success" %}
**Strive for loosely coupled designs between objects that interact**
{% endhint %}

Loosely couples designs allow us to build a flexible OO system that can handle change because they minimize the interdependency between objects.

## When to Use?

When you need many other objects to receive the update when another object changes

## Pros ( :thumbsup: ) & Cons ( :thumbsdown: )

:thumbsup: Loose coupling - Subject ( Publisher ) doesn't need to know about the Observer ( Subscriber ).

:thumbsup: You can establish relations between objects at runtime.

:thumbsup: Changes to either the subject or an observer will not affect the other.



:thumbsdown: Subject ( Publisher ) may send the updates that don't matter to the observer ( Subscriber ).



## Code

{% embed url="https://gist.github.com/SunilGudivada/00c2205814b7e4682a924887baf67bae" %}

## Reference

* [https://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/](https://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/)
* [https://refactoring.guru/design-patterns/observer](https://refactoring.guru/design-patterns/observer)
* [https://sourcemaking.com/design\_patterns/observer](https://sourcemaking.com/design\_patterns/observer)

##
