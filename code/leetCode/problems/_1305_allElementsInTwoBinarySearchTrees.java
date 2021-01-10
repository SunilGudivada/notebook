package leetCode.problems;

import java.util.*;


/**
 * Given two binary search trees root1 and root2.
 *
 * <p>Return a list containing all the integers from both trees sorted in ascending order.
 *
 * <p>Example 1:
 *
 * <p>Input: root1 = [2,1,4], root2 = [1,0,3] Output: [0,1,1,2,3,4] Example 2:
 *
 * <p>Input: root1 = [0,-10,10], root2 = [5,1,7,0,2] Output: [-10,0,0,1,2,5,7,10] Example 3:
 *
 * <p>Input: root1 = [], root2 = [5,1,7,0,2] Output: [0,1,2,5,7] Example 4:
 *
 * <p>Input: root1 = [0,-10,10], root2 = [] Output: [-10,0,10] Example 5:
 *
 * <p>Input: root1 = [1,null,8], root2 = [8,1] Output: [1,1,8,8]
 *
 * <p>Constraints:
 *
 * <p>Each tree has at most 5000 nodes. Each node's value is between [-10^5, 10^5].
 */
public class _1305_allElementsInTwoBinarySearchTrees {

  public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

    Stack<TreeNode> S1 = new Stack(), S2 = new Stack();
    List<Integer> result = new ArrayList();
    while(root1 != null || root2 != null || !S1.empty() || !S2.empty()){
      while(root1 != null){
        S1.push(root1);
        root1 = root1.left;
      }
      while(root2 != null){
        S2.push(root2);
        root2 = root2.left;
      }
      if(S2.empty() || (!S1.empty() && S1.peek().val <= S2.peek().val)){
        root1 = S1.pop();
        result.add(root1.val);
        root1 = root1.right;
      } else {
        root2 = S2.pop();
        result.add(root2.val);
        root2 = root2.right;
      }
    }
    return result;
  }

  public static void main(String[] args){

  }
}
