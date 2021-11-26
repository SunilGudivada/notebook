package geeksForGeeks.trees;

public class HeightBalancedTree {

    public int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isHeightBalanced(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int l = height(root.left);
        int r = height(root.right);
        return Math.abs(l - r) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right);
    }

    public int optimizedHeightBalanced(Node root) {
        if (root == null) return 0;

        int lh = optimizedHeightBalanced(root.left);
        if (lh == -1) return -1;
        int rh = optimizedHeightBalanced(root.right);
        if (rh == -1) return -1;
        
        if (Math.abs(lh - rh) > 1) return -1;
        else return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        System.out.println(new HeightBalancedTree().isHeightBalanced(root));
        System.out.println(new HeightBalancedTree().optimizedHeightBalanced(root));
    }
}
