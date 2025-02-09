package year2025.february;

public class MaximumPathSumFromAnyNode {

    static int maxSum;

    public static void main(String[] args) {

    }

    int findMaxSum(Node node) {
        // your code goes here
        // your code goes here
        if (node == null) return 0;
        maxSum = Integer.MIN_VALUE;
        dfs(node);
        return maxSum;

    }

    int dfs(Node node) {
        if (node == null) return 0;
        int leftsubtree = dfs(node.left);
        int rightsubtree = dfs(node.right);
        int a = Math.max(leftsubtree + node.data, rightsubtree + node.data);
        int b = Math.max(leftsubtree + rightsubtree + node.data, node.data);
        maxSum = Math.max(maxSum, Math.max(a, b));
        return Math.max(a, node.data);
    }

}
