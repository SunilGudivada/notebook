package geeksForGeeks.trees;

/**
 * AVL tree is a self-balancing Binary Search Tree (BST) where the difference between heights of
 * left and right subtrees cannot be more than one for all nodes.
 */
public class AVLTree {
  Node insert(Node node, int data) {
    if (node == null) {
      return (new Node(data));
    }
    if (node.data > data) {
      node.left = insert(node.left, data);
    } else {
      node.right = insert(node.right, data);
    }
    // update the node height
    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

    int balDiff = getBalance(node);

    // Left Rotate
    if (balDiff > 1 && data < node.left.data) {
      return rightRotate(node);
    }

    // Right Rotate
    if (balDiff < -1 && data > node.right.data) {
      return leftRotate(node);
    }

    // Left Right Rotate
    if (balDiff > 1 && data > node.left.data) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }

    // Right Left Rotate
    if (balDiff < -1 && data < node.right.data) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    return node;
  }

  public int getBalance(Node n) {
    if (n != null) {
      return (getHeight(n.left) - getHeight(n.right));
    }
    return 0;
  }

  public int getHeight(Node n) {
    if (n != null) {
      return n.height;
    }
    return 0;
  }

  Node rightRotate(Node y) {

    Node x = y.left;
    Node T2 = x.right;

    x.right = y;
    y.left = T2;

    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

    return x;
  }

  Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    y.left = x;
    x.right = T2;

    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

    return y;
  }
}
