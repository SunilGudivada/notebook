package geeksForGeeks.trees;

public class Node {

  int data;
  int height;
  Node left;
  Node right;

  Node(int key) {
    this.data = key;
    height = 1;
  }
}
