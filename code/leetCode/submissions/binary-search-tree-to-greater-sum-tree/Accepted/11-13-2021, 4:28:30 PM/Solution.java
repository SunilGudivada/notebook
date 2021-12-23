// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static List<Integer> list = new ArrayList<>();

    public void convert(TreeNode root) {
        if (root != null) {
            convert(root.right);
            int inOrderNodeIndex = list.indexOf(root.val);
            int inOrderValue = 0;
            if (inOrderNodeIndex + 1 < list.size()) {
                inOrderValue = list.get(inOrderNodeIndex + 1);
                list.add(inOrderNodeIndex, root.val + inOrderValue);
            }
            root.val += inOrderValue;
            convert(root.left);
        }
    }
    
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }


    public TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        convert(root);
        list.clear();
        return root;
    }
}