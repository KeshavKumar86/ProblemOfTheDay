package year2025.february;

import java.util.ArrayList;

public class KSumPaths {

    int count = 0;
    public static void main(String[] args) {

    }

    public int sumK(Node root, int k) {
        // code here
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, k, path);
        return count;
    }

    void helper(Node root, int k, ArrayList<Integer> path) {
        if (root == null) return;

        path.add(root.data);
        int sum = 0;

        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) count++;
        }

        helper(root.left, k, path);
        helper(root.right, k, path);

        path.remove(path.size() - 1);
    }
}
