package leetCode.problems;

import java.util.*;

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * Example 2:
 *
 * Input: root = [0,null,1]
 * Output: [1,null,1]
 * Example 3:
 *
 * Input: root = [1,0,2]
 * Output: [3,3,2]
 * Example 4:
 *
 * Input: root = [3,2,4,1]
 * Output: [7,9,4,10]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * 0 <= Node.val <= 100
 * All the values in the tree are unique.
 * root is guaranteed to be a valid binary search tree.
 *
 *
 * Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class _1038_BinarySearchTreetoGreaterSumTree {
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
