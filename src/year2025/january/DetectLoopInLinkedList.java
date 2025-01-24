package year2025.january;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopInLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = null;
        System.out.println("Detect Loop: " + detectLoop(head1));

    }

    private static boolean detectLoop(Node head) {

        Set<Node> set = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (!set.add(temp)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
/*
Solution1: Naive Solution
Intuition: Take one loop of size more than the size of the list, and run the loop if in between pointer
becomes null that means there is no cycle. if it comes out of loop than there is some cycle
Time Complexity: O(n)
Space Complexity: O(1)

Solution2: Better approach
Intuition: As we know every address is unique in memory, so store the addresses of the nodes in the set
and if any address repeats that means that list has loop.
Time Complexity: O(n)
Space Complexity: O(n)
 */