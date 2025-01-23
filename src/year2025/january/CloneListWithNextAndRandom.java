package year2025.january;

import java.util.HashMap;

public class CloneListWithNextAndRandom {
    public static void main(String[] args) {

        Node head1 = new Node(5);
        head1.next = new Node(7);
        head1.next.next = new Node(10);
        head1.next.next.next = new Node(13);
        head1.next.next.next.next = new Node(15);
        Node result = cloneLinkedList(head1);
        while(result!=null){
            System.out.print(result.data + " -> ");
            result = result.next;
        }
    }

    private static Node cloneLinkedList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.data));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            temp = temp.next;
        }
        return map.get(head);
    }
}
