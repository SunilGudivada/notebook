---
description: >-
  Design pattern that provides an interface for creating objects in a
  superclass, but allows subclasses to alter the type of objects that will be
  created.
---

# Factory Method Design Pattern

## When to use it?

Use the Factory Method when&#x20;

:ledger:  you don’t know beforehand the exact types and dependencies of the objects your code should work with.

:ledger:  you want to save system resources by reusing existing objects instead of rebuilding them each time.

:ledger:  you want to provide users of your library or framework with a way to extend its internal components.



## Pros & Cons

:green\_circle: You avoid tight coupling between the creator and the concrete products.

:green\_circle: _Single Responsibility Principle_. You can move the product creation code into one place in the program, making the code easier to support.

:green\_circle: _Open/Closed Principle_. You can introduce new types of products into the program without breaking the existing client code.



:red\_circle: The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best-case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.\


## Code

To be updated.



## References

* [https://refactoring.guru/design-patterns/factory-method](https://refactoring.guru/design-patterns/factory-method)
* [https://www.youtube.com/watch?v=ub0DXaeV6hA\&list=PLF206E906175C7E07\&index=5](https://www.youtube.com/watch?v=ub0DXaeV6hA\&list=PLF206E906175C7E07\&index=5)
*

\
