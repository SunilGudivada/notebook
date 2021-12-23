// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    
    public static class SegmentTreeNode {

        public int start;
        public int end;
        public int sum;

        public SegmentTreeNode left;
        public SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            sum = 0;
        }

    }

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

        if (node.start == index && node.end == index) {
            node.sum += 1;
            return;
        }

        int mid = (node.start + node.end) / 2;
        if (index <= mid) {
            update(node.left, index);
        } else {
            update(node.right, index);
        }

        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end) {
            return 0;
        }

        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return sumRange(root.left, start, end);
        } else if (start > mid) {
            return sumRange(root.right, start, end);
        }

        return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
    }

    public List<Integer> countSmaller(int[] arr) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) return new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int e : arr) {
            min = Math.min(min, e);
            max = Math.max(max, e);
        }

        SegmentTreeNode node = buildTree(min, max);
        for (int i = arr.length - 1; i >= 0; i--) {
            update(node, arr[i]);
            int sum = sumRange(node, min, arr[i] - 1);
            res.add(sum);
        }
        Collections.reverse(res);
        return res;
    }
}