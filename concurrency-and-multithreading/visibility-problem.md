# Visibility Problem

Suppose there are two threads having shared variables.

&#x20;![](<../.gitbook/assets/image (109) (1).png>)

&#x20;

Consider the above image. If thread 1 is changing the variable value, changes won't be affected in thread 2. To flush the changes from thread 1 to thread 2 we should use `volatile` keywords. But volatile doesn't ensure values changes are effected in case ++ operations. since it has read and write operations. We can use **a synchronized** block or **Atomic Operations**

### Performance Considerations of volatile

Reading and writing of volatile variables cause the variable to be read or written to the main memory. Reading from and writing to main memory is more expensive than accessing the CPU cache. Accessing volatile variables also prevents instruction reordering which is a normal performance enhancement technique. Thus, you should only use volatile variables when you really need to enforce the visibility of variables.



**Note:**

* For Visibility use **Volatile**
* For Compound Operations use **Atomic Operations** ( AtomicInteger, AtomicLong, AtomicReference )
