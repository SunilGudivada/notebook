# Queue Implementations

## Using LinkedList

```java
public class LinkedListQueue {
  private Node head, tail;

  // Inner class
  private class Node {
    String item;
    Node next;
  }

  public boolean isEmpty() {
    return head == null;
  }

  // To insert an item
  public void enqueue(String item) {
    Node oldtail = tail;
    tail = new Node();
    tail.item = item;
    tail.next = null;
    if (isEmpty()) head = tail;
    else oldtail.next = tail;
  }

  // To remove and item
  public String dequeue() {
    String item = head.item;
    head = head.next;
    if (isEmpty()) tail = null;
    return item;
  }
}
```

