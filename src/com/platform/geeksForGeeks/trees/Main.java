package com.platform.geeksForGeeks.trees;

public class Main {
  public static void main(String[] args) {

    /**
     *                 10
     *              20    30
     *           40   50    60
     *                       70
     */
    Node root = new Node(10);
    Node node1 = new Node(20);
    Node node2 = new Node(30);
    Node node3 = new Node(40);
    Node node4 = new Node(50);
    Node node5 = new Node(60);
    Node node6 = new Node(70);

    root.left = node1;
    root.right = node2;

    node1.left = node3;
    node1.right = node4;

    node2.right = node5;
    node5.right = node6;

    Functions functions = new Functions();

    System.out.println("\nIn Order Traversal of a Binary Tree : ");
    functions.inOrder(root);

    System.out.println("\n\nPre Order Traversal of a Binary Tree : ");
    functions.preOrder(root);

    System.out.println("\n\nPost Order Traversal of a Binary Tree : ");
    functions.postOrder(root);

    System.out.println("\n\nLevel Order Traversal of a Binary Tree : ");
    functions.levelOrder(root);

    System.out.println("\n\nHeight of the Binary Tree: "+ functions.height(root));
  }
}
