package geeksForGeeks.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Functions {
  public void inOrder(Node root) {
    if (root == null) return;
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public void preOrder(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public void postOrder(Node root) {
    if (root == null) return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data + " ");
  }

  /**
   * Level Order Traversal
   *
   * @param root Node of the Tree
   */
  public void levelOrder(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Node curr = q.poll();
      System.out.print(curr.data + " ");
      if (curr.left != null) q.add(curr.left);
      if (curr.right != null) q.add(curr.right);
    }
  }

  public static int height(Node root) {
    if (root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
  }

  public static int getBalanceFactor(Node node) {
    Functions functions = new Functions();
    return functions.height(node.left) - functions.height(node.right);
  }

  public void zigzag(Node root) {
    if (root == null) return;
    Stack<Node> q = new Stack<>();
    Stack<Node> s = new Stack<>();

    boolean isEven = true;

    q.add(root);

    while (!q.isEmpty() || !s.isEmpty()) {

      if (isEven) {
        Node curr = q.pop();
        System.out.print(curr.data + " ");
        if (curr.left != null) s.push(curr.left);
        if (curr.right != null) s.push(curr.right);
      } else {
        Node curr = s.pop();
        System.out.print(curr.data + " ");
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

  static int GCD(int a, int b) {
    if (a == 0) return b;
    if (b == 0) return a;

    if (a == b) return a;

    if (a > b) return GCD(a - b, b);
    return GCD(a, b - a);
  }

  public static boolean isBST(Node root) {
    return isValidBST(root, null, null);
  }

  public static boolean isValidBST(Node root, Integer min, Integer max) {
    if (root == null) return true;
    if ((min != null && root.data <= min) || (max != null && root.data >= max)) return false;
    return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
  }

  public static Node mirrorImage(Node node) {
    if (node == null) return null;

    Node left = mirrorImage(node.left);
    Node right = mirrorImage(node.right);

    node.left = right;
    node.right = left;
    return node;
  }

  public static boolean isTreeBalanced(Node node) {
    if (node == null) return true;
    int lheight = height(node.left);
    int rheight = height(node.right);
    if(Math.abs(lheight-rheight) < 1 && isTreeBalanced(node.left) && isTreeBalanced(node.right)){
      return true;
    }
    return false;
  }
}
