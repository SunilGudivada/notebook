package geeksForGeeks.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> traverse(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curr = new ArrayList<>();
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top != null) {
                curr.add(top.data);
                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            } else {
                ArrayList<Integer> c_curr = new ArrayList<>(curr);
                res.add(c_curr);
                curr.clear();
                if (!q.isEmpty()) q.offer(null);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        System.out.println(new LevelOrderTraversal().traverse(root));

    }
}
