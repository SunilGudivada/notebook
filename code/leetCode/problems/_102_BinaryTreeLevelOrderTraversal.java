package leetCode.problems;

import java.util.*;

/**
 *Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class _102_BinaryTreeLevelOrderTraversal {
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
