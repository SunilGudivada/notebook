// https://leetcode.com/problems/binary-search-tree-iterator

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
class BSTIterator {
    List<TreeNode> list = new ArrayList<>();
    int currentIndex = -1;
    
    private void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
    
    public BSTIterator(TreeNode root) {
        inOrder(root);        
    }
    
    public int next() {
        return list.get(++currentIndex).val;
    }
    
    public boolean hasNext() {
        return currentIndex+1 < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */