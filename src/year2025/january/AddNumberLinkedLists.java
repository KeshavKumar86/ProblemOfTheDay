package year2025.january;

public class AddNumberLinkedLists {
    public static void main(String[] args) {

        Node head1 = new Node(4);
        head1.next = new Node(5);
        /*head1.next.next = new Node(1);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = new Node(7);
        head1.next.next.next = new Node(1);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = new Node(7);*/


        Node head2 = new Node(9);
        head2.next = new Node(5);
        head2.next.next = new Node(5);
        /*head2.next.next.next = new Node(9);
        head2.next.next.next.next = new Node(11);
        head2.next.next.next.next.next = new Node(14);*/

        Node temp = addTwoLists(head1, head2);
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    static Node addTwoLists(Node num1, Node num2) {

        Node head1 = reverse(num1);
        Node head2 = reverse(num2);

        int carry = 0;
        Node result = null, tail = null;

        // Process both lists together
        while (head1 != null || head2 != null || carry != 0) {
            int number1 = (head1 != null) ? head1.data : 0;
            int number2 = (head2 != null) ? head2.data : 0;
            int sum = number1 + number2 + carry;

            // Update carry and the node value
            carry = sum / 10;
            Node temp = new Node(sum % 10);

            // Append to the result list
            if (result == null) {
                result = temp; // First node
                tail = result;
            } else {
                tail.next = temp;
                tail = temp;
            }

            // Move to the next nodes
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        // Reverse the result list back
        result = reverse(result);
        while (result != null && result.data == 0) {
            result = result.next;
        }
        return result;

    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
