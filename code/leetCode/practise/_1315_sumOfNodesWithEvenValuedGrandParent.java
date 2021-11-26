package leetCode.practise;


import geeksForGeeks.trees.Node;

public class _1315_sumOfNodesWithEvenValuedGrandParent {
    public int helper(Node node, int p, int gp) {
        if (node == null) return 0;
        return helper(node.left, node.data, p) + helper(node.right, node.data, p) + (gp % 2 == 0 ? node.data : 0);
    }

    public int sumEvenGrandparent(Node root) {
        if(root == null) return 0;
        return helper(root, 1, 1);
    }
}
