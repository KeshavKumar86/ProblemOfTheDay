package year2025.january;

import java.util.HashMap;

public class LRUCache {

    int capacity;
    DoubleNode head = new DoubleNode(0, 0);
    DoubleNode tail = new DoubleNode(0, 0);
    HashMap<Integer, DoubleNode> map;

    public static void main(String[] args) {

    }

    LRUCache(int cap) {
        capacity = cap;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        // your code here
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            delete(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            delete(node);
            node.value = value;
            insert(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(head.next.key);
                delete(head.next);

            }
            DoubleNode newNode = new DoubleNode(key, value);
            insert(newNode);
            map.put(key, newNode);
        }

    }

    // insert at last (make most recent)
    void insert(DoubleNode node) {
        DoubleNode prev = tail.prev;
        prev.next = node;
        node.next = tail;
        node.prev = prev;
        tail.prev = node;
    }

    //delete from anywhere
    void delete(DoubleNode current) {
        DoubleNode prev = current.prev;
        DoubleNode next = current.next;
        prev.next = next;
        next.prev = prev;
    }
}

class DoubleNode {
    int key;
    int value;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
/*
Solution1: Naive Solution
Intuition: we will use a linked list to implement the LRU cache.Idea is simple we will have LRU elements
at the start and most recently used elements at the end.So basically we will add the elements from
end, and we will remove the elements from the start if we required.
we will have 2 pointers head and tail to point to the LRU and MRU elements.
get operation: we will search the elements from start and find the elements, after finding it we will
return its value now it is most recently used, so we will delete it and insert from the end to make it
MRU.To delete we require prev and next of it, so we will use doubly linked list.
put() operation: if key already exists then delete it and insert at the end with updated value.
if key is not already present - 1. if capacity is not full simply insert at the end.
2. if capacity is full delete from the start and insert at the end.
Time Complexity: O(n) for get and put operation
Space Complexity: O(n)

Solution2 : optimal Solution
To reduce the time to get the element is constant time we should use hashmap.
So we will use hashmap<key,Node> to map the keys and nodes.
so that we can get the node using key is constant time.
Time Complexity: O(1) for get and put operation
Space Complexity: O(n)

 */