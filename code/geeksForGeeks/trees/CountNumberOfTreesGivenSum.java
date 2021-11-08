package geeksForGeeks.trees;

public class CountNumberOfTreesGivenSum {

    int count =0;

    int countSubTree(Node root, int x){
        findSum(root, x);
        return count;
    }

    int findSum(Node root, int x){
        if(root == null) return 0;
        int currentSum = root.data + findSum(root.left, x) + findSum(root.right , x);
        if(currentSum == x) count++;
        return currentSum;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(-10);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(8);
        root.right.left = new Node(-4);
        root.right.right = new Node(7);
        int x = 7;

        System.out.println(new CountNumberOfTreesGivenSum().countSubTree(root, x));
    }
}
