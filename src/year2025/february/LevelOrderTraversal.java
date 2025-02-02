package year2025.february;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = queue.remove();
                al.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(al);
        }
        return result;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
/*
Solution1: Optimal Solution
Intuition: We have to print the elements level by level, so what we will do is we will add the elements
of the level in the queue, and we iterate the queue level by level and add the all elements of the same
level in the arraylist, and we do it repeatedly until queue is not empty.
Time Complexity: O(n)
Space Complexity: O(n)
 */