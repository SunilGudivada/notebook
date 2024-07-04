# Binary Search Tree

Node definition in a binary tree

```java
// Node
private class TreeNode
{
    private Key key;
    private Value val;
    private Node left, right;
    public Node(Key key, Value val)
    {
        this.key = key;
        this.val = val;
    }
}
```

**The basic idea of binary tree algorithm design**: Defining the manipulation in the current node and the last things are thrown to the framework.

```java
void traverse(TreeNode root) {
    // The manipulation required in the root node should be written here.
    // Other things will be resolved by the framework.
    traverse(root.left);
    traverse(root.right);
}
```

## **Identical Binary trees ?**

```java
boolean isSameTree(TreeNode root1, TreeNode root2) {
    // If they are null, they are identical obviously
    if (root1 == null && root2 == null) return true;
    // If one of the nodes is void, but the other is not null, they are not identical
    if (root1 == null || root2 == null) return false;
    // If they are all not void, but their values are not equal, they are not identical
    if (root1.val != root2.val) return false;

    // To recursively compare every pair of the node
    return isSameTree(root1.left, root2.left)
        && isSameTree(root1.right, root2.right);
}
```

It is straightforward to understand the two above examples with the help of the traverse framework of the binary tree. If you can understand it, now you can handle all the problems with the binary tree.

Binary Search Tree (BST), is a common type of binary. The tree additionally satisfies the binary search property, which states that the key in each node must be greater than or equal to any key stored in the left sub-tree, and less than or equal to any key stored in the right sub-tree.

An example corresponding to the definition is shown as:

![Valid BST](<../../../.gitbook/assets/image (28) (1).png>)

Next, we will realize basic operations with BST, including compliance checking of BST, addition, deletion, and search. The process of deletion and compliance checking may be slightly more complicated.

## **Compliance checking of BST**

This operation sometimes is error-prone. Following the framework mentioned above, the manipulation of every node in the binary tree is to compare the key in the left child with the right child, and it seems that the codes should be written like this:

```java
boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    if (root.left != null && root.val <= root.left.val) return false;
    if (root.right != null && root.val >= root.right.val) return false;

    return isValidBST(root.left)
        && isValidBST(root.right);
}
```

But such algorithm is an error. Because the key in each node must be greater than or equal to any key stored in the left sub-tree, and less than or equal to any key stored in the right sub-tree. For example, the following binary tree is not a BST, but our algorithm will make the wrong decision.

![Invalid BST](<../../../.gitbook/assets/image (29) (1).png>)

Don't panic though the algorithm is wrong. Our framework is still correct, and we didn't notice some details information. Let's refresh the definition of BST: The manipulations in root node should not only include the comparison between left and right child, but it also require a comparison of the whole left and right sub-tree. What should do? It is beyond the reach of the root node.

In this situation, we can use an auxiliary function to add parameters in the parameter list, which can carry out more useful information. The correct algorithm is as follows:

```java
boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
}

boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    if (root == null) return true;
    if (min != null && root.val <= min.val) return false;
    if (max != null && root.val >= max.val) return false;
    return isValidBST(root.left, min, root) 
        && isValidBST(root.right, root, max);
}
```

## **Lookup function in BST**

According to the framework, we can write the codes like this:

```java
boolean isInBST(TreeNode root, int target) {
    if (root == null) return false;
    if (root.val == target) return true;

    return isInBST(root.left, target)
        || isInBST(root.right, target);
}
```

It is entirely right. If you can write like this, you have remembered the framework. Now you can attempt to take some details into account: How to leverage the property of BST to facilitate us to search efficiently.

It is effortless! We don't have to search both of nodes recursively. Similar to the binary search, we can exclude the impossible child node by comparing the target value and root value. We can modify the codes slightly:

```java
boolean isInBST(TreeNode root, int target) {
    if (root == null) return false;
    if (root.val == target)
        return true;
    if (root.val < target) 
        return isInBST(root.right, target);
    if (root.val > target)
        return isInBST(root.left, target);
    // The manipulations in the root node are finished, and the framework is done, great!
```

Therefore, we can modify the original framework to abstract a new framework for traversing BST.

```java
void BST(TreeNode root, int target) {
    if (root.val == target)
        // When you find the target, your manipulation should be written here
    if (root.val < target) 
        BST(root.right, target);
    if (root.val > target)
        BST(root.left, target);
}
```

## **Deletion function in BST**

This problem is slightly complicated. But you can handle it with the help of the framework! Similar to the insert function, we should find it before modification. Let's write it first:

```java
TreeNode deleteNode(TreeNode root, int key) {
    if (root.val == key) {
        // When you find it, you can delete it here.
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
}
```

When you find the target, for example, node A. It isn't effortless for us to delete it. Because we can't destroy the property of BST when we realize the Deletion function. There are three situations, and we will illustrate in the following three pictures:

**Case 1**: Node A is just the leaf node, and it's child nodes are all null. In this way, we can delete it directly.

The picture is excerpted from LeetCode

![](<../../../.gitbook/assets/image (27) (1).png>)

```java
if (root.left == null && root.right == null)
    return null;
```

**Case 2**: The node A has only one child node, then we can change its child node to replace its place.

The picture is excerpted from LeetCode

![](<../../../.gitbook/assets/image (26) (1).png>)

```java
// After excluding the Situation 1
if (root.left == null) return root.right;
if (root.right == null) return root.left;
```

**Case 3**: Node A has two child nodes. To avoid destroying the property of BST, node A must find the maximum node in left sub-tree or the minimum node in the right sub-tree to replace its place. We use the minimum node in the right sub-tree to illustrate it.

The picture is excerpted from LeetCode

![](<../../../.gitbook/assets/image (67).png>)

```java
if (root.left != null && root.right != null) {
    // Find the minimum node in right sub-tree
    TreeNode minNode = getMin(root.right);
    // replace root node to minNode 
    root.val = minNode.val;
    // Delete the root node subsequently
    root.right = deleteNode(root.right, minNode.val);
}
```

The three situations are analyzed, and we can fill them into the framework and simplify the codes:

```java
TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val == key) {
        // These two IF function handle the situation 1 and situation 2
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // Deal with situation 3
        TreeNode minNode = getMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, minNode.val);
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
}

TreeNode getMin(TreeNode node) {
    // The left child node is the minimum
    while (node.left != null) node = node.left;
    return node;
}
```

In this way, we can finish the deletion function. Note that such an algorithm is not perfect because we wouldn't exchange the two nodes by 'root.val = minNode.val'. Generally, we will exchange the root and minNode by a series of slightly complicated linked list operations. Because the value of Val may be tremendous in the specific application, it's time-consuming to modify the value of the node. Still, the linked list operations only require to change the pointer and don't modify values.

## Floor in BST

* **Case 1:**`k` equals the key at root - floor of _**key**_ is `k`
* **Case 2:** `k`is less than the _**key**_ at root - The floor of k is in the left subtree.
* **Case 3**: k is greater than the key at root - The floor of k is in the right subtree (if there is any key ≤ k in right subtree); otherwise it is the key in the root.

```java
public Key floor(Key key)
{
    Node x = floor(root, key);
    if (x == null) return null;
    return x.key;
}
private Node floor(Node x, Key key)
{
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    
    // Case 1
    if (cmp == 0) return x;
    
    // Case 2 
    if (cmp < 0) return floor(x.left, key);
    
    // Case 3
    Node t = floor(x.right, key);
    if (t != null) return t;
    else return x;
}
```

## �Subtree Counts

To get the number of the nodes in the tree, we need to add one more attribute in the treeNode definition and while adding the node to the tree, update the size of count

```java
// Node
private class TreeNode
{
    private Key key;
    private Value val;
    private int count;
    private Node left, right;
    public Node(Key key, Value val)
    {
        this.key = key;
        this.val = val;
    }
}
```

```java
// Size Calculation
public int size(){
    return size(root); 
}

public int size(TreeNode x){
    if (x == null) return 0;
     return x.count;
}
```

```java
public TreeNode put(TreeNode x, Key key, Value val){
    if( x == null) return new TreeNode(key, val);
    int cmp = key.compareTo(x.key);
    if(cmp < 0)
        x.left = put(x.left, key, val)
    else if(cmp > 0 ) 
        x.right = put(x.right, key, val);
    else
        x.val = val;
    x.size = 1 + size(x.left) + size(s.right); // Line to be added
    return x;
}
```

## Rank of the Node

How many keys less than K ?

```java
public int rank(Key key){
    return rank(key, root);
}

public int rank(Key key, TreeNode x){
    if(x == null) return 0;
    int cmp = key.compareTo(x.key);
    if( cmp == 0) return size(x.left);
    else if( cmp < 0) return rank(key, x.left);
    else if(cmp > 0) return 1 + size(x.left) + rank(key, x.right);
}
```

## Traversal

### Inorder Traversal

```java
public Queue<key> inOrder(TreeNode x){
    Queue<Key> q = new Queue<Key>();
     inOrder(root, q);
     return q;
}

public void inOrder(TreeNode x, Queue<key> q){
    if(x == null) return;
    inOrder(x.left);
    q.enqueue(x.key);
    inOrder(x.right);
}
```

### Pre Order Traversal

```java
public Queue<key> preOrder(TreeNode x){
     Queue<Key> q = new Queue<Key>();
     preOrder(root, q);
     return q;
}

public void preOrder(TreeNode x, Queue<key> q){
    if(x == null) return;
    q.enqueue(x.key);
    preOrder(x.left);
    preOrder(x.right);
}
```

### Post Order Traversal

```java
public Queue<key> postOrder(TreeNode x){
     Queue<Key> q = new Queue<Key>();
     postOrder(root, q);
     return q;
}

public void postOrder(TreeNode x, Queue<key> q){
    if(x == null) return;
    postOrder(x.left);
    postOrder(x.right);
    q.enqueue(x.key);
}
```

### Level Order Traversal

```java
public Queue<Key> levelOrder(TreeNode x){
    Queue<Key> res = new Queue<Key>();
    Queue<TreeNode> q = new Queue<TreeNode>();
    
    q.add(x);
    
    while(!q.isEmpty()){
        TreeNode t = q.poll();
        res.add(t.key);
        if(x.left != null) q.add(x.left);
        if(x.right != null)q.add(x.right);
    }
    return res;
}
```

### Zig Zag Traversal

```java
public Queue<key> zigzag(TreeNode x){
    if (x == null) return;
    Queue<key> res = new Queue<>();
    Stack<TreeNode> q = new Stack<>();
    Stack<TreeNode> s = new Stack<>();

    boolean isEven = true;

    q.add(root);

    while (!q.isEmpty() || !s.isEmpty()) {

      if (isEven) {
        TreeNode curr = q.pop();
        res.add(curr.key);
        if (curr.left != null) s.push(curr.left);
        if (curr.right != null) s.push(curr.right);
      } else {
        TreeNode curr = s.pop();
        res.add(curr.key);
        if (curr.right != null) q.push(curr.right);
        if (curr.left != null) q.push(curr.left);
      }

      if (q.isEmpty() && !s.isEmpty()) {
        isEven = false;
      }
      if (s.isEmpty() && !q.isEmpty()) {
        isEven = true;
      }
    }
}
```

**Summary**

In this article, you can learn the following skills:

1. The basic idea of designing a binary tree algorithm: Defining the manipulations in the current node and the last things are thrown to the framework.
2. If the manipulations in the current node have influence in its sub-tree, we can add additional parameters to the parameter list by adding auxiliary function.
3. On the foundation of the framework of the binary tree, we abstract the traverse framework of BST:

```java
void BST(TreeNode root, int target) {
    if (root.val == target)
        // When you find the target, your manipulation should be written here
    if (root.val < target) 
        BST(root.right, target);
    if (root.val > target)
        BST(root.left, target);
}
```
