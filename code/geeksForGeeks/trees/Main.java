package geeksForGeeks.trees;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    System.out.println("\n\n\n******************************");
    System.out.println("AVL Tree");
    System.out.println("******************************");


    AVLTree AVL_OBJ = new AVLTree();

    Node[] AVL_ROOT_NODE = {null};

    Stream.generate(() -> new Random().nextInt(100)).limit(30).distinct().collect(Collectors.toList()).forEach(s -> AVL_ROOT_NODE[0] = AVL_OBJ.insert(AVL_ROOT_NODE[0], s));

//    AVL_ROOT_NODE = AVL_OBJ.insert(AVL_ROOT_NODE, 20);
//    AVL_ROOT_NODE = AVL_OBJ.insert(AVL_ROOT_NODE, 30);
//    AVL_ROOT_NODE = AVL_OBJ.insert(AVL_ROOT_NODE, 40);
//    AVL_ROOT_NODE = AVL_OBJ.insert(AVL_ROOT_NODE, 50);
//    AVL_ROOT_NODE = AVL_OBJ.insert(AVL_ROOT_NODE, 60);
//    AVL_ROOT_NODE = AVL_OBJ.insert(AVL_ROOT_NODE, 70);
//    AVL_ROOT_NODE = AVL_OBJ.insert(AVL_ROOT_NODE, 80);
//    AVL_ROOT_NODE = AVL_OBJ.insert(AVL_ROOT_NODE, 90);

//        functions.inOrder(AVL_ROOT_NODE[0]);


    System.out.println("\nHeight of a AVL Tree : "+ functions.height(AVL_ROOT_NODE[0]));

    System.out.println("\nIn Order Traversal of a AVL Tree : ");
    functions.inOrder(AVL_ROOT_NODE[0]);

    System.out.println("\n\nPre Order Traversal of a AVL Tree : ");
    functions.preOrder(AVL_ROOT_NODE[0]);

    System.out.println("\n\nPost Order Traversal of a AVL Tree : ");
    functions.postOrder(AVL_ROOT_NODE[0]);

    System.out.println("\n\nLevel Order Traversal of a AVL Tree : ");
    functions.levelOrder(AVL_ROOT_NODE[0]);


    System.out.println("\n\n\n******************************");
    System.out.println("Segment Tree");
    System.out.println("******************************");


    int[] array = new int[] {1, 2, 3, 4, 5, 6};

    System.out.println("MINIMUM SEGMENT TREE");
    SegmentTree MIN_SEGMENT_TREE = new SegmentTree(array, Integer::min, 0);
    MIN_SEGMENT_TREE.build();
    System.out.println(MIN_SEGMENT_TREE);

    System.out.println("Output in range 1, 3 is " + MIN_SEGMENT_TREE.findOutputIn(1, 3));
    System.out.println("Output in range 2, 5 is " + MIN_SEGMENT_TREE.findOutputIn(2, 5));
    System.out.println("Output in range 1, 6 is " + MIN_SEGMENT_TREE.findOutputIn(1, 6));
    System.out.println("Output in range 5, 6 is " + MIN_SEGMENT_TREE.findOutputIn(5, 6));
    System.out.println("Output in range 1, 4 is " + MIN_SEGMENT_TREE.findOutputIn(1, 4));
    System.out.println();

    System.out.println("MAXIMUM SEGMENT TREE");
    SegmentTree MAX_SEGMENT_TREE = new SegmentTree(array, Integer::max, 0);
    MAX_SEGMENT_TREE.build();
    System.out.println(MAX_SEGMENT_TREE);

    System.out.println("Output in range 1, 3 is " + MAX_SEGMENT_TREE.findOutputIn(1, 3));
    System.out.println("Output in range 2, 5 is " + MAX_SEGMENT_TREE.findOutputIn(2, 5));
    System.out.println("Output in range 1, 6 is " + MAX_SEGMENT_TREE.findOutputIn(1, 6));
    System.out.println("Output in range 5, 6 is " + MAX_SEGMENT_TREE.findOutputIn(5, 6));
    System.out.println("Output in range 1, 4 is " + MAX_SEGMENT_TREE.findOutputIn(1, 4));
    System.out.println();

    System.out.println("SUM SEGMENT TREE");
    SegmentTree SUM_SEGMENT_TREE = new SegmentTree(array, Integer::sum, 0);
    SUM_SEGMENT_TREE.build();
    System.out.println(SUM_SEGMENT_TREE);

    System.out.println("Output in range 1, 3 is " + SUM_SEGMENT_TREE.findOutputIn(1, 3));
    System.out.println("Output in range 2, 5 is " + SUM_SEGMENT_TREE.findOutputIn(2, 5));
    System.out.println("Output in range 1, 6 is " + SUM_SEGMENT_TREE.findOutputIn(1, 6));
    System.out.println("Output in range 5, 6 is " + SUM_SEGMENT_TREE.findOutputIn(5, 6));
    System.out.println("Output in range 1, 4 is " + SUM_SEGMENT_TREE.findOutputIn(1, 4));
    System.out.println();

    System.out.println("GCD SEGMENT TREE");
    SegmentTree GCD_SEGMENT_TREE = new SegmentTree(array, Functions::GCD, 0);
    GCD_SEGMENT_TREE.build();
    System.out.println(GCD_SEGMENT_TREE);

    System.out.println("Output in range 1, 3 is " + GCD_SEGMENT_TREE.findOutputIn(1, 3));
    System.out.println("Output in range 2, 5 is " + GCD_SEGMENT_TREE.findOutputIn(2, 5));
    System.out.println("Output in range 1, 6 is " + GCD_SEGMENT_TREE.findOutputIn(1, 6));
    System.out.println("Output in range 5, 6 is " + GCD_SEGMENT_TREE.findOutputIn(5, 6));
    System.out.println("Output in range 1, 4 is " + GCD_SEGMENT_TREE.findOutputIn(1, 4));


    System.out.println("Mirror Image of a Tree");
    Node MIRROR_ROOT_NODE = new Node(10);
    MIRROR_ROOT_NODE.left = new Node(20);
    MIRROR_ROOT_NODE.right = new Node(30);
    MIRROR_ROOT_NODE.right.right = new Node(40);
    System.out.println("\nBefore:::In order Traversal");
    functions.inOrder(MIRROR_ROOT_NODE);
    Functions.mirrorImage(MIRROR_ROOT_NODE);
    System.out.println("\nAfter:::In order Traversal");
    functions.inOrder(MIRROR_ROOT_NODE);


    System.out.print("\n\n Is Valid BST");
    Node VALID_BST_NODE = new Node(10);
    VALID_BST_NODE.left = new Node(10);
//    VALID_BST_NODE.right = new Node(25);
//
//    VALID_BST_NODE.left.left = new Node(2);
//    VALID_BST_NODE.left.right = new Node(22);

    System.out.print(Functions.isBST(VALID_BST_NODE));
  }
}
