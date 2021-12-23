// https://leetcode.com/problems/validate-binary-search-tree

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
    private int prev = Integer.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        return isBST(root);
    }
    
    public boolean isBST(TreeNode root){
        if(root == null){ return true; }
        if(!isBST(root.left)){ return false; }
        if(root.val <= prev){ return false; }
        prev = root.val;
        return isBST(root.right);
    }
}