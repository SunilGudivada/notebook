package com.platform.leetCode;

import java.util.*;

class TreeNode {
  int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }

 }

public class allElementsInTwoBinarySearchTrees {

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
