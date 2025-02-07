package year2025.february;

import java.util.ArrayList;

public class InorderTraversal {

    public static void main(String[] args) {

    }

    ArrayList<Integer> inOrder(Node root) {

        return inOrderTraversal(root, new ArrayList<>());
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

