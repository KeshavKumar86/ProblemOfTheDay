package year2025.february;

public class HeightOfBinaryTree {
    public static void main(String[] args) {

    }

    static int height(Node node) {

        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
/*
Solution1: Optimal Solution
Intuition: to count the length of the tree, what we can do is calculate the length of left subtree and
length of right subtree , now the height of the tree is
1 + Max(height(left subtree),height(right subtree))
Time complexity: O(n)
Space complexity: O(n)
 */