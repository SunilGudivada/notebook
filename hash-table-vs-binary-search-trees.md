# Hash Table vs Binary Search Trees

## Hash Tables

* Simpler to code.
* No effective alternative for unordered keys.
* Faster for simple keys \(a few arithmetic ops versus log N compares\).
* Better system support in Java for strings \(e.g., cached hash code\).

## Binary Search Trees

* Stronger performance guarantee.
* Support for ordered ST operations.
* Easier to implement compareTo\(\) correctly than equals\(\) and hashCode\(\).

## Java Implementations

**Red-black BSTs**: java.util.TreeMap, java.util.TreeSet.

**Hash Tables:** java.util.HashMap, java.util.IdentityHashMap.



