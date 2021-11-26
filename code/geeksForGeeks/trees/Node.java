package geeksForGeeks.trees;

public class Node {

    public Node left;
    public int data;
    public int height;
    public Node right;

    public Node(int key) {
        this.data = key;
        height = 1;
    }
}
