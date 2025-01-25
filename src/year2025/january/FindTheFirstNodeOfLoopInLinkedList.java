package year2025.january;

public class FindTheFirstNodeOfLoopInLinkedList {
    public static void main(String[] args) {

        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = head1.next;

    }

    public static Node findFirstNode(Node head) {

        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
/*
Solution1: Naive Solution
Use the set and store the addresses of the nodes in the set, whenever the address repeats,that is the
first node of the loop.
Time Complexity: O(n)
Space Complexity: O(n)

Solution2: Optimal Solution
1.First use the fast & slow pointers to detect the loop
2.Find Starting node of Loop: After detecting that the loop is present using above algorithm, to
find the starting node of loop in linked list, we will reset the slow pointer to head node and fast
pointer will remain at its position. Both slow and fast pointers move one step ahead until fast not
equals to slow. The meeting point will be the Starting node of loop.
Time Complexity: O(n)
Space Complexity: O(1)
 */