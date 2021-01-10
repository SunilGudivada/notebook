package geeksForGeeks.trees;

public class BinarySearchTree {

  Node insert(Node node, int key) {
    if (node == null) {
      node = new Node(key);
      return node;
    }
    if (key < node.data) node.left = insert(node.left, key);
    else if (key > node.data) node.right = insert(node.right, key);
    return node;
  }

  Node delete(Node root, int key) {

    if (root == null) return root;

    if (key < root.data) root.left = delete(root.left, key);
    else if (key > root.data) root.right = delete(root.right, key);
    else {

      // Node having 0 or 1 children
      if (root.left == null) return root.right;
      else if (root.right == null) return root.left;

      // Node having 2 children
      // Replace the value with next Inorder Element and Delete the Inorder Element Node
      // PS: Since java uses pass by reference root value changed to next inOrder Element.
      root.data = getNextInOrderValue(root.right);
      root.right = delete(root.right, root.data);
    }

    return root;
  }

  static int getNextInOrderValue(Node root) {

    int minValue = root.data;
    while (root.left != null) {
      minValue = root.left.data;
      root = root.left;
    }
    return minValue;
  }
}
