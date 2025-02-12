package year2025.february;

import java.util.ArrayList;

public class KthSmallestInBST {
    public static void main(String[] args) {

    }

    public int kthSmallest(Node root, int k) {

        ArrayList<Integer> list = inOrderTraversal(root, new ArrayList<>());
        if (k > list.size()) {
            return -1;
        }
        return list.get(k - 1);
    }

    private ArrayList<Integer> inOrderTraversal(Node root, ArrayList<Integer> integers) {

        if (root == null) {
            return null;
        }
        inOrderTraversal(root.left, integers);
        integers.add(root.data);
        inOrderTraversal(root.right, integers);
        return integers;
    }
}
