package com.platform.geeksForGeeks.trees;

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
   * @param root Node of the Tree
   *
   */
  public void levelOrder(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
      Node curr=q.poll();
      System.out.print(curr.data+" ");
      if(curr.left!=null)
        q.add(curr.left);
      if(curr.right!=null)
        q.add(curr.right);
    }
  }

  public int height(Node root) {
    if (root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
  }
}
