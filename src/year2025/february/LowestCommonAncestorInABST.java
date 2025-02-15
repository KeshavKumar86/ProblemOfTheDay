package year2025.february;

public class LowestCommonAncestorInABST {
    public static void main(String[] args) {

    }

    Node LCA(Node root, Node n1, Node n2) {

        if (root == null) {
            return null;
        }
        if (root == n1) {
            return n1;
        }
        if (root == n2) {
            return n2;
        }
        if (root.data < n1.data && root.data < n2.data) {
            return LCA(root.right, n1, n2);
        } else if (root.data > n1.data && root.data > n2.data) {
            return LCA(root.left, n1, n2);
        } else {
            return root;
        }
    }
    /*Node LCA(Node root, Node n1, Node n2) {

        if (root == null) {
            return null;
        }
        int low = Math.min(n1.data, n2.data);
        int high = Math.max(n1.data, n2.data);
        if (root.data == low || root.data == high || (root.data > low && root.data < high)) {
            return root;
        }
        if (root.data < low) {
            return LCA(root.right, n1, n2);
        }
        if (root.data > high) {
            return LCA(root.left, n1, n2);
        }
        return null;


    }*/
}
/*
Solution1: Optimal Solution (Using recursion)
Intuition: if root is less than both n1 and n2 then find the LCA in right subtree.
if root is greater than both n1 and n2 then find the LCA in the left subtree.
else return the root.(one is on the left side and other is on the right side)
Time Complexity: O(h)
Space Complexity: O(h)

Solution2: better Solution
Replace recursion with loop, and we can save space used for recursion.
Time Complexity: O(h)
Space Complexity: O(1)
 */