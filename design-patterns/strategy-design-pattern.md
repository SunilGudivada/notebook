---
description: lets the algorithm vary independently from clients that use it
---

# Strategy Design Pattern

## When to use it?

* When you want to define a class that will have one behavior that is similar to other behavior in the list.&#x20;
* When you need to use one of the several behaviors dynamically

## Pros ( :thumbsup:) & Cons ( :thumbsdown:):



* :thumbsup: Often reduces the long list of conditionals
* :thumbsup: Reduce duplicate code
* :thumbsup: Keeps class changes from forcing other class changes
* :thumbsup: can hide complicated/secret code from the user
* :thumbsup:You can replace inheritance with composition.



* :thumbsdown: Increased number of objects and classes
* :thumbsdown:A lot of modern programming languages have functional-type support that lets you implement different versions of an algorithm inside a set of anonymous functions. Then you could use these functions exactly as you’d have used the strategy objects, but without bloating your code with extra classes and interfaces.

\----

> The [Strategy](https://refactoring.guru/design-patterns/strategy) pattern can be implemented with a simple anonymous (lambda) function in most modern programming languages.

## Code:

{% embed url="https://gist.github.com/SunilGudivada/7afe42412dfec5cc64cbc567ef3470c7" %}

## References:

[https://www.newthinktank.com/2012/08/strategy-design-pattern-tutorial/](https://www.newthinktank.com/2012/08/strategy-design-pattern-tutorial/) [https://refactoring.guru/design-patterns/strategy](https://refactoring.guru/design-patterns/strategy)[https://sourcemaking.com/design\_patterns/strategy](https://sourcemaking.com/design\_patterns/strategy)
