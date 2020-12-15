package com.platform.geeksForGeeks.trees;

public class Main {
  public static void main(String[] args) {

    /** 10 20 30 40 50 60 70 80 */
    Node root = new Node(10);
    Node node1 = new Node(20);
    Node node2 = new Node(30);
    Node node3 = new Node(40);
    Node node4 = new Node(50);
    Node node5 = new Node(60);
    Node node6 = new Node(70);
    Node node7 = new Node(80);

    root.left = node1;
    root.right = node2;

    node1.left = node3;
    node1.right = node4;

    node2.right = node5;
    node4.right = node6;
    node5.right = node7;

    Functions functions = new Functions();

    System.out.println("\nIn Order Traversal of a Binary Tree : ");
    functions.inOrder(root);

    System.out.println("\n\nPre Order Traversal of a Binary Tree : ");
    functions.preOrder(root);

    System.out.println("\n\nPost Order Traversal of a Binary Tree : ");
    functions.postOrder(root);

    System.out.println("\n\nLevel Order Traversal of a Binary Tree : ");
    functions.levelOrder(root);

    System.out.println("\n\nHeight of the Binary Tree: " + functions.height(root));

    System.out.println("\n Zig Zag Traversal of a Binary Tree: ");
    functions.zigzag(root);

    System.out.println("\n\n\n******************************");
    System.out.println("Binary Search Tree");
    System.out.println("******************************");

    String BST_TREE = """
                         50
                 30             70
             20     40      60       80
         10                              90
     """;

    BinarySearchTree BST_OBJ = new BinarySearchTree();

    Node BST_ROOT_NODE = new Node(50);

    BST_OBJ.insert(BST_ROOT_NODE, BST_ROOT_NODE.data);
    BST_OBJ.insert(BST_ROOT_NODE, 30);
    BST_OBJ.insert(BST_ROOT_NODE, 20);
    BST_OBJ.insert(BST_ROOT_NODE, 40);
    BST_OBJ.insert(BST_ROOT_NODE, 70);
    BST_OBJ.insert(BST_ROOT_NODE, 60);
    BST_OBJ.insert(BST_ROOT_NODE, 80);
    BST_OBJ.insert(BST_ROOT_NODE, 10);
    BST_OBJ.insert(BST_ROOT_NODE, 90);

    System.out.println(BST_TREE);
    System.out.println("\nHeight of a Binary Search Tree : "+ functions.height(BST_ROOT_NODE));

    System.out.println("\nIn Order Traversal of a Binary Search Tree : ");
    functions.inOrder(BST_ROOT_NODE);

    System.out.println("\n\nPre Order Traversal of a Binary Search Tree : ");
    functions.preOrder(BST_ROOT_NODE);

    System.out.println("\n\nPost Order Traversal of a Binary Search Tree : ");
    functions.postOrder(BST_ROOT_NODE);

    System.out.println("\n\n Deleting a root Node ( 50 ) in Binary Search Tree ");
    BST_OBJ.delete(BST_ROOT_NODE, 50);

    System.out.println("\n\nLevel Order Traversal of a Binary Search Tree : ");
    functions.levelOrder(BST_ROOT_NODE);


  }
}
