package scaler.hashing;

import java.util.ArrayList;

public class HashMapImplementation {

    class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private ArrayList<Node>[] buckets;

    private static final int DEFAULT_CAPACITY = 2;
    private static final float LOAD_FACTOR = 2.0f;

    public HashMapImplementation() {
        initiate(DEFAULT_CAPACITY);
    }

    public HashMapImplementation(int capacity) {
        initiate(capacity);
    }

    private void initiate(int capacity) {
        this.buckets = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<>();
        }
        this.size = 0;
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        int bucketNumber = hash(key);
        int nodeIndex = getNodeIndexOfKey(bucketNumber, key);

        if (nodeIndex == -1) {
            Node node = new Node(key, value);
            buckets[bucketNumber].add(node);
        } else {
            buckets[bucketNumber].get(nodeIndex).value = value;
        }
        size++;

        float lambda = ((float) size) / capacity;

        if (lambda > LOAD_FACTOR) {
            reHash();
        }
    }

    public int get(int key) {
        int bucketNumber = hash(key);
        int nodeIndex = getNodeIndexOfKey(bucketNumber, key);

        if (nodeIndex == -1) return -1;

        return buckets[bucketNumber].get(nodeIndex).value;
    }

    public int remove(int key) {
        int bucketNumber = hash(key);
        int nodeIndex = getNodeIndexOfKey(bucketNumber, key);

        if (nodeIndex == -1) return -1;

        int value = buckets[bucketNumber].get(nodeIndex).value;
        buckets[bucketNumber].remove(nodeIndex);

        size--;
        return value;
    }

    public int size() {
        return this.size;
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    private int getNodeIndexOfKey(int bucketNumber, int key) {
        ArrayList<Node> bucket = buckets[bucketNumber];
        int index = 0;
        for (Node node : bucket) {
            if (node.key == key) {
                return index;
            }
            index++;
        }

        return -1;
    }

    private void reHash() {
        ArrayList<Node>[] oldBucket = buckets;
        initiate(capacity * 2);
        size = 0;
        for (int i = 0; i < oldBucket.length; i++) {
            for (Node node : oldBucket[i]) {
                put(node.key, node.value);
            }
        }
    }

    public static void main(String[] args) {
        HashMapImplementation map = new HashMapImplementation();
        map.put(1, 10);      // store (1 → 10)
        map.put(5, 20);      // store (5 → 20)
        map.put(7, 30);      // store (5 → 20)
        map.put(8, 50);      // store (5 → 20)
        map.put(6, 3);      // store (5 → 20)
        map.put(2, 100);      // store (5 → 20)
        map.put(9, -5);      // store (5 → 20)
        map.put(20, 5);      // store (5 → 20)
        map.put(11, 20);      // store (5 → 20)
        map.get(1);          // returns 10
        map.get(2);          // key not found → -1
        map.put(9, 30);      // store (9 → 30)
        map.size();          // returns 3
        map.remove(5);       // removes key 5 → returns 20
        map.size();          // returns 2
    }
}
