package leetCode.problems;

import java.util.*;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Example 2:
 *
 * Input: nums = [-1]
 * Output: [0]
 * Example 3:
 *
 * Input: nums = [-1,-1]
 * Output: [0,0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */

class SegmentTreeNode {
    public SegmentTreeNode left;
    public SegmentTreeNode right;

    public int Start;
    public int End;
    public int Sum;

    public SegmentTreeNode(int start, int end) {
        Start = start;
        End = end;
        Sum = 0;
    }
}

public class _315_CountOfSmallerNumbersAfterSelf {

    public SegmentTreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end);

        if (start == end) {
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = buildTree(start, mid);
        node.right = buildTree(mid + 1, end);

        return node;
    }

    public void update(SegmentTreeNode node, int index) {
        if (node == null) {
            return;
        }
        if (node.Start == index && node.End == index) {
            node.Sum += 1;
            return;
        }
        int mid = node.Start + (node.End - node.Start) / 2;
        if (index <= mid) {
            update(node.left, index);
        }
        else {
            update(node.right, index);
        }
        node.Sum = node.left.Sum + node.right.Sum;
    }

    public int SumRange(SegmentTreeNode root, int start, int end) {
        if (root == null || start >end) {
            return 0;
        }

        if (root.Start == start && root.End == end) {
            return root.Sum;
        }
        int mid = root.Start + (root.End - root.Start) / 2;
        if (end <= mid) {
            return SumRange(root.left, start, end);
        }
        else if (start > mid) {
            return SumRange(root.right, start, end);
        }
        return SumRange(root.left, start, mid) + SumRange(root.right, mid + 1, end);
    }


    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int[] counts = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int el : nums) {
            min = Math.min(min, el);
            max = Math.max(max, el);
        }

        SegmentTreeNode root = buildTree(min, max);

        for (int i = nums.length - 1; i >= 0; i--) {
            update(root, nums[i]);
            counts[i] = SumRange(root, min, nums[i] - 1);
        }


        List<Integer> ans = new ArrayList<>();
        for (int i : counts) {
            ans.add(i);
        }
        return ans;
    }
}
