// https://leetcode.com/problems/binary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null ) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> levelList = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode currentElement = q.poll();
            if(currentElement == null){
                res.add(levelList);
                levelList = new ArrayList<>();
                if(!q.isEmpty()){
                 q.offer(null);
                }
            }else{
                levelList.add(currentElement.val);
                if(currentElement.left !=null) q.offer(currentElement.left);
                if(currentElement.right !=null) q.offer(currentElement.right);
            }
        }
        return res;
    }
}