package year2025.january;

public class RotateALinkedList {
    public static void main(String[] args) {

        int k = 1;
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        temp = rotate(head, k);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static Node rotate(Node head, int k) {

        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        k = k % size;
        if (k == size || k == 0) {
            return head;
        }
        Node pt1 = null, pt2 = null;
        int i = 1;
        while (temp.next != null) {
            if (i == k) {
                pt1 = temp;
                pt2 = pt1.next;
            }
            i++;
            temp = temp.next;
        }
        pt1.next = null;
        temp.next = head;
        return pt2;
    }
}
/*
Solution1: Naive Approach
1.Store the elements of list in the array and reverse the array using reversal algorithm.
2.Update the values with the rotated array values.
Time Complexity: O(n)
Space Complexity: O(n)

Solution2: Naive Solution2
1.Rotate the list by 1 element.
2.Repeat the first step k times
Time Complexity: O(n*k)
Space Complexity: O(1)

Solution3: Optimal Solution
1.Count the size of the list.
2.k = k%size
3.Take one variable i and iterate the list and get hold of the kth element, (k+1)th element and last
element.
4.make the next of last as head. next of kth as null and return the (k+1)th element address.
Time Complexity: O(n)
Space Complexity: O(1)
 */
