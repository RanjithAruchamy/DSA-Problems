package scaler.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
     * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
     *
     * Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
     *
     * NOTE: If you are using any global variables, make sure to clear them in the constructor.
     *
     * Example :
     *
     * Input :
     *          capacity = 2
     *          set(1, 10)
     *          set(5, 12)
     *          get(5)        returns 12
     *          get(1)        returns 10
     *          get(10)       returns -1
     *          set(6, 14)    this pushes out key = 5 as LRU is full.
     *          get(5)        returns -1
     */

    private static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Map<Integer, ListNode> map;
    private Integer maxCapacity;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        ListNode node = map.get(key);
        deleteNode(node);
        ListNode newNode = insertBeforeTail(key, node.val);
        map.put(key, newNode);

        return newNode.val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            deleteNode(map.get(key));
            map.remove(key);
        }

        if (map.size() == maxCapacity) {
            // Remove the head.next node
            map.remove(head.next.key);
            deleteNode(head.next);
        }

        ListNode newNode = insertBeforeTail(key, value);
        map.put(key, newNode);
    }

    private ListNode insertBeforeTail (int key, int value) {
        ListNode temp = tail.prev;

        ListNode newNode = new ListNode(key, value);
        newNode.next = tail;
        newNode.prev = temp;

        temp.next = newNode;
        tail.prev = newNode;

        return newNode;
    }

    private void deleteNode(ListNode node) {
        ListNode next = node.next;
        ListNode prev = node.prev;

        next.prev = prev;
        prev.next = next;

        node.prev = null;
        node.next = null;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(5, 12);
        System.out.println(cache.get(5));
        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        cache.set(6, 14);
        System.out.println(cache.get(5));
    }
}
