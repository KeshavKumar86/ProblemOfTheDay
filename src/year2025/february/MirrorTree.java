package year2025.february;

public class MirrorTree {
    public static void main(String[] args) {

    }

    void mirror(Node node) {

        if (node == null)
            return;
        Node left = node.left;

        node.left = node.right;
        node.right = left;

        mirror(node.left);
        mirror(node.right);
    }
}
/*
Solution1: Optimal Solution
To find the mirror image we have to make left child as right and right child as left and we have to do
recursively for all the subtrees.
Time Complexity: O(n)
Space Complexity: O(h)
 */