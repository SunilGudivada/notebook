package geeksForGeeks.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeProblems {

    int maxValue = Integer.MIN_VALUE;

    public int maxOfBinaryTreeRecursion(Node root) {
        if (root != null) {
            int leftMaxValue = maxOfBinaryTreeRecursion(root.left);
            int rightMaxValue = maxOfBinaryTreeRecursion(root.right);
            maxValue = Math.max(leftMaxValue, rightMaxValue);
            maxValue = Math.max(maxValue, root.data);
        }
        return maxValue == Integer.MIN_VALUE ? -1 : maxValue;
    }

    public int maxOfBinaryTree(Node root) {
        if(root==null) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node current = q.poll();
            max = Math.max(current.data, max);
            if (current.left != null) q.offer(current.left);
            if (current.right != null) q.offer(current.right);

        }

        return max;
    }

    public static void main(String[] args) {

        BinaryTreeProblems BinaryTree = new BinaryTreeProblems();

        Node root = new Node(5);
        root.right = new Node(9);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        System.out.println("[R] Is height Balanced in the binary Tree::: " + new HeightBalancedTree().isHeightBalanced(root));
        System.out.println("[O] Is height Balanced in the binary Tree::: " + new HeightBalancedTree().optimizedHeightBalanced(root));
        System.out.println("[R] Maximum element in the binary tree::: " + BinaryTree.maxOfBinaryTreeRecursion(root));
        System.out.println("[I] Maximum element in the binary tree::: " + BinaryTree.maxOfBinaryTree(root));
    }
}
