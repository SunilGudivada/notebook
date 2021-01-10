package leetCode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class _1379_FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {

  // O(n) using level order traversal
  public final TreeNode getTargetCopy(
      final TreeNode original, final TreeNode cloned, final TreeNode target) {
    TreeNode root = cloned;
    Queue<TreeNode> queue = new LinkedList();
    queue.add(root);
    while (queue.size() > 0) {
      root = queue.poll();
      if (root.val == target.val) return root;
      if (root.left != null) queue.add(root.left);
      if (root.right != null) queue.add(root.right);
    }
    return null;
  }
}
