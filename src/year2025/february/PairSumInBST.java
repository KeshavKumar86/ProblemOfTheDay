package year2025.february;

import java.util.ArrayList;

public class PairSumInBST {
    public static void main(String[] args) {

    }

    boolean findTarget(Node root, int target) {

        ArrayList<Integer> list = inOrderTraversal(root, new ArrayList<>());
        //use 2 pointer to search the target
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int sum = list.get(low) + list.get(high);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return false;
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
