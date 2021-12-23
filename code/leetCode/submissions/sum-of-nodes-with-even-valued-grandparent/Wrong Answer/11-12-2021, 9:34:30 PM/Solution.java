// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent

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
    int sum =0;
    public int calculate(TreeNode root){
        int result =0;
        if(root.left == null && root.right == null) return 0;
        if(root.left !=null){
            if(root.left.left != null) result +=root.left.left.val;
            if(root.left.right != null) result +=root.left.right.val;
        }
        if(root.right !=null){
            if(root.right.left != null) result +=root.right.left.val;
            if(root.right.right != null) result +=root.right.right.val;
        }
        return result;
        
    }
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;
        sum = ((root.val&1 )== 0) ?calculate(root): 0;
        return sum + 
            ((root.left != null && (root.left.val &1) == 0 )? sumEvenGrandparent(root.left):0) + 
            ((root.right != null && (root.right.val &1) == 0 )? sumEvenGrandparent(root.right):0);
    }
}