package year2025.february;

public class DiameterOfABinaryTree {

    int max = 0;

    public static void main(String[] args) {

        //4 41 N 75 79 4 56 N 54 N N 91 73 N 82 N N N N N N
    }

    int diameter(Node root) {

        height(root);
        return max;

    }

    int height(Node node) {

        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
/*
Solution1: Optimal Solution
Intuition: At a node diameter will be the height of the left side plus height of the right side.
But because it is not necessary that diameter will pass through root, so the diameter will be the
maximum of the diameter at every node.
So we will take a variable maximum and calculate its maximum value. we did not return it in the same
function.We will return the height only but side by side diameter will calculate its value.
Time Complexity: O(n)
Space complexity: O(h)
 */