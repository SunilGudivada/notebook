package leetCode.practise;

import geeksForGeeks.trees.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1038_convertBST2GT {

    public static List<Integer> list = new ArrayList<>();

    public void convert(Node root) {
        Queue<Integer> q = new LinkedList<>();
        if (root != null) {
            convert(root.right);
            int inOrderNodeIndex = list.indexOf(root.data);
            int inOrderValue = 0;
            if (inOrderNodeIndex + 1 < list.size()) {
                inOrderValue = list.get(inOrderNodeIndex + 1);
                list.add(inOrderNodeIndex, root.data + inOrderValue);
            }
            root.data += inOrderValue;
            convert(root.left);
        }
    }

    public Node bstToGst(Node root) {
        convert(root);
        return root;
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.data);
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(1);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        root.left.left = new Node(0);
        root.left.right = new Node(2);
        root.left.right.right = new Node(3);


        new _1038_convertBST2GT().inOrder(root);
        System.out.println(list);
        System.out.println(new _1038_convertBST2GT().bstToGst(root));
        new _1038_convertBST2GT().preOrder(root);
    }
}
