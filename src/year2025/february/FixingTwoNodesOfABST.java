package year2025.february;

public class FixingTwoNodesOfABST {

    Node prev, first, second;

    public static void main(String[] args) {

    }

    void correctBST(Node root) {

        prev = first = second = null;
        solve(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    void solve(Node root) {
        if (root == null) return;
        solve(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                second = root;
            } else second = root;
        }
        prev = root;
        solve(root.right);
    }

}
