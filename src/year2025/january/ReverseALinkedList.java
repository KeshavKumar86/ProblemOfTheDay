package year2025.january;

public class ReverseALinkedList {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        temp = reverseList(head);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static Node reverseList(Node head) {

        Node pointer1 = head;
        if (head.next == null) {
            return head;
        }
        Node pointer2 = head.next;
        Node pointer3 = pointer2.next;
        head.next = null;
        while (pointer2 != null) {
            pointer2.next = pointer1;
            pointer1 = pointer2;
            pointer2 = pointer3;
            if (pointer2 != null) {
                pointer3 = pointer2.next;
            }
        }
        return pointer1;
    }
}

class Node {
    int data;
    Node next;

    Node(int value) {
        this.data = value;
    }
}
/*
Solution1: Brute Force Solution
1.Add all the elements of linkedList into arrayList in first iteration
2.Update the values of all nodes from the end of arrayList in second iteration.
Time Complexity: O(n)
Space Complexity: O(n)

Solution2: Optimal Solution (Iterative)
Intuition: Take 3 pointers and make the next of pt2.next = pt1. and then update the pointers
pt1 = pt2
pt2 = pt3
pt3 = pt3.next
Remember to make the head.next = null to remove any infinite loop.
Time Complexity: O(n)
Space Complexity: O(1)

Solution3: Recursive Solution
We will add this solution later when we study recursion.
 */
