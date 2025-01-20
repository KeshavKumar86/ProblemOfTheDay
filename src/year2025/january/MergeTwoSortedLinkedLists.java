package year2025.january;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {

        //head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
        Node head1 = new Node(5);
        head1.next = new Node(7);
        head1.next.next = new Node(10);
        head1.next.next.next = new Node(13);
        head1.next.next.next.next = new Node(15);


        Node head2 = new Node(4);
        head2.next = new Node(6);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(9);
        head2.next.next.next.next = new Node(11);
        head2.next.next.next.next.next = new Node(14);
        Node temp = head1;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        temp = sortedMerge(head1, head2);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    private static Node sortedMerge(Node head1, Node head2) {

        Node dummy = new Node(0);
        Node tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }
        return dummy.next;
    }
}
/*
Solution1: Brute Force Solution
1.Store the elements of the list into the array.
2.Sort the array
3.Update the values of the list with the new sorted array values.
Time Complexity: O(n+m)log(n+m)
Space Complexity: O(n+m)

Solution2: Better Solution
1.Initialize a new head as null.
2.take 2 pointers to point to the lists.
3.Compare the values of 2 pointers and create a new node with the less value and head will point
to this node. Increase the pointer which has less value.
4.Repeat the process.
Time Complexity: O(n+m)
Space Complexity: O(n+m)

Solution3: Optimal Solution
The idea is to iteratively merge two sorted linked lists using a dummy node to simplify the process.
A current pointer tracks the last node of the merged list. We compare the nodes from both lists and
append the smaller node to the merged list. Once one list is fully traversed, the remaining nodes from
the other list are appended. The merged list is returned starting from the node after the dummy node.
Time Complexity: O(n+m)
Space Complexity: O(1)
 */