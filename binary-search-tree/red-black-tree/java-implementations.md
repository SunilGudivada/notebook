# Java Implementations

## Node Implementation

```java
private static final boolean RED = true;
private static final boolean BLACK = false;

class TreeNode{
    private Key key;
    private Value val;
    private TreeNode left;
    private TreeNode right;
    private boolean color;
    
    // ....... constructor ........
}

private boolean isRed(Node x){
    if(x == null) return false;
    return x.color == RED;
}
```

![](<../../.gitbook/assets/image (63).png>)

## Search Operation

**Observation**. Search is the same as for elementary BST ( ignore color ).

![](<../../.gitbook/assets/image (62).png>)

```java
public class redBlackTree {
    public key search(TreeNode x, key key){
        if(x == null) return null;
        while(x!=null){
            int cmp = (key).compareTo(x.key);
            if( cmp < 0 ) x = x.left;
            else if( cmp > 0 ) x = x.right;
            else return  x.key;
        }
        return null;
    }
}
```

## Elementary operations

### Left Rotation

![](<../../.gitbook/assets/image (64).png>)

![](<../../.gitbook/assets/image (70).png>)

```java
private TreeNode rotateLeft(TreeNode h)
 {
     assert isRed(h.right);
     TreeNode x = h.right;
     h.right = x.left;
     x.left = h;
     x.color = h.color;
     h.color = RED;
     return x;
 }
```

### Right Rotation

**Invariants:** Maintains symmetric order and perfect black balance.

![](<../../.gitbook/assets/image (66).png>)

![](<../../.gitbook/assets/image (67).png>)

```java
private TreeNode rotateRight(TreeNode h)
 {
     assert isRed(h.left);
     TreeNode x = h.left;
     h.left = x.right;
     x.right = h;
     x.color = h.color;
     h.color = RED;
     return x;
 }
```

### Color Flip

![](<../../.gitbook/assets/image (68).png>)

![](<../../.gitbook/assets/image (69).png>)

```java
public void colorFlip(TreeNode h){
    assert !isRed(h);
    assert isRed(h.left);
    assert isRed(h.right);
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
}
```

## Insertion

**Basic Strategy:** Maintain 1-1 correspondence with 2-3 trees by applying elementary red-black BST operations.

### Case 1: Into Exactly 2-node

* Do standard BST insert; color new link red
* If new red link is a right link, rotate left.

![Explanation for inserting a node in 2-node](<../../.gitbook/assets/image (72).png>)

**Example**: Insert ' C '

![Example for inserting a node in 2-node](<../../.gitbook/assets/image (74).png>)

### Case 2: Insert into 3-node

* Do standard BST insert; color new link red.
* Rotate to balance the 4-node ( if needed ).
* Flip colors to pass red link up one level.
* Rotate to make lean left (if needed).

![Explanation for inserting a node in 3-node](<../../.gitbook/assets/image (75).png>)

**Example**: Inserting ' H '

![Example for inserting a node in 3-node Red Black Tree](<../../.gitbook/assets/image (76).png>)

### Passing red links up the tree

* Do standard BST insert; color new link red.
* Rotate to balance the 4-node ( if needed ).
* Flip colors to pass red link up one level.
* Rotate to make lean left (if needed).
* Repeat case 1, case 2 ( if needed ).

**Example:**

![](<../../.gitbook/assets/image (77).png>)

### Java Implementation

```java
private Node put(Node h, Key key, Value val)
 {
     // insert at bottom with color RED
     if (h == null) return new Node(key, val, RED);
     int cmp = key.compareTo(h.key);
     
     if (cmp < 0) h.left = put(h.left, key, val);
     else if (cmp > 0) h.right = put(h.right, key, val);
     else if (cmp == 0) h.val = val;
     
     //lean left
     // Right child red, left child black: rotate left.
     if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
     
     // balance 4-node
     // Left child, left-left grandchild red: rotate right.
     if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
     
     // split 4-node
     // Both children red: flip colors.
     if (isRed(h.left) && isRed(h.right)) flipColors(h);
    
     return h;
 }
```

## Delete

Delete operations are bit complicated.
