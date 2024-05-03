# Stack Implementations

## Using Linked Lists

```java
public class LinkedListOfStrings {
    private node head = null ;
    
    // Inner class
    private class Node
    {
         String item;
         Node next;
     }
     
     public boolean isEmpty {
         return head == null;
     }
     
     public void push(String item) {
         Node oldNode = head;
         Node newNode  = null;
         newNode.item = item;
         item.next = oldNode;
     }
     
     public String pop(){
         String item = head.item;
         head = head.next;
         return item;
     }
     
     
}
```

### Memory Calculation for Node

```java
/** 
* ====================
* Memory Calculations
* ====================
*
* Class Overhead + Inner class over head + Item + Node  
* 
* 16 + 8 + 8 + 8 = 40 bytes
* 
* For N Nodes , Total Memory 40 * N ( in bytes )
*/
public class Node {
    String item;
    Node next;
}
```

## Using Array - Fixed size

```java
public class ArrayFixedSizeStack {

    int MAX_CAPACITY = 0;
    
    // Top element in the stack
    private int N = 0;
    
    public ArrayStack(int capacity){
        this.MAX_CAPACITY = capacity;
    }
    
    private String[] stack = new String[MAX_CAPACITY];
    
    // check if stack is empty or not
    public boolean isEmpty() {
        return N == 0;
    }
    
    // adding an element to the stack
    public void push(String item) {
        if( N++ <= MAX_CAPACITY){ 
            stack[N++] = item;
        }else{
            throw new StackOverflowException("Stack Over flow exception");
        }
    }
    
    // deleting an element to the stack
    public String pop(){
        if(N == 0 ){
            throw new StackUnderflowException("Stack Underflow exception occured");
        }       
        return stack[--N];
    }
}
```

## Using Array - dynamic size

```java
public class ArrayDynamicSizeStack {
    
    private String[] stack;
    private int N;
    
    // Initializing the size of the stack to '1'
    public ArrayDynamicSizeStack(){
        stack = new String[1];
    }    
    
    // check if stack is empty or not
    public boolean isEmpty() {
        return stack.length == 0;
    }
    
    // adding an element to the stack
    public void push(String item) {
        if(N == stack.length){
            resize(2 * stack.length);
        }
        stack[N++] = item;
    }
    
    // deleting an element to the stack
    public String pop(){
        String item =  stack[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4){
             resize(s.length/2);
         }
        return item;
    }
    
    // resizing the capacity of the array
    public void reSize(int capacity){
        String copy = new String[capacity];
        for(int i=0;i<N;i++){
            copy[i] = stack[i];
        }
        stack = copy;
    }
}
```

## Generic Stack Linked List Implementation

```java
public class Stack<K> {
  private Node first = null;

  private class Node {
    K item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void push(K item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
  }

  public K pop() {
    K item = first.item;
    first = first.next;
    return item;
  }
}
```

## Generic Stack Array Implementation

```java
public class FixedCapacityStack<K> {
  private K[] s;
  private int N = 0;

  public FixedCapacityStack(int capacity) {
    s = (K[]) new Object[capacity];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void push(K item) {
    s[N++] = item;
  }

  public K pop() {
    return s[--N];
  }
}
```

## Stack Iteration

```java
public class stackIteration {
....

 for (String s : stack)
  System.out.println(s);
 
 ...
 
}
```

## Trade offs

Can implement a stack with either resizing array or linked list. Which one is better?

#### Linked List Implementation:

* Every operation takes constant time in the worst case.
* Uses extra time and space to deal with the links.

#### Resizing-array implementation:

* Every operation takes constant amortized time.
* Less wasted space.
