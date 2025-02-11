package year2025.february;

import java.util.ArrayList;

public class CheckForBST {
    public static void main(String[] args) {

    }

    boolean isBST(Node root) {

        ArrayList<Integer> list = inorderTraversal(root, new ArrayList<>());
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }

    ArrayList<Integer> inorderTraversal(Node root, ArrayList<Integer> list) {

        if (root == null) {
            return null;
        }
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
        return list;
    }
}
