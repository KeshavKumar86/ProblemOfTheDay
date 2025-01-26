package year2025.january;

public class RemoveLoopInLinkedList {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;
    }

    private static void removeLoop(Node head) {

        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}
/*
Solution1: Brute Force Solution
Use the set and detect the starting point of the loop and then find the node having next as starting
point of the loop and make it as null.
Time Complexity: O(n)
Space Complexity: O(n)

Solution1: Optimal Solution
1.First detect the loop using fast pointer and slow pointer.
2.Then find the starting point of the loop using Floyd's Cycle Detection Algorithm
3.Then iterate the fast until fast.next!=slow and make fast.next as null.
Time Complexity: O(n)
Space Complexity: O(1)
 */