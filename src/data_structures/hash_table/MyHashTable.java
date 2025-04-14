package data_structures.hash_table;

import java.util.*;

public class MyHashTable<K, V> {

    public MyHashTable(int capacity) {
        this.length = capacity;
        data = new ArrayList[length];
    }

    /** HashTable implementation
     * key, value pair of nodes
     * put, get, remove, containsKey methods
     * */

    private int length;
    private ArrayList<MyNode<K, V>>[] data;

    private final Set<K> keySet = new HashSet<>();
    private final Set<MyNode<K, V>> entrySet = new HashSet<>();
    private final Collection<V> values = new ArrayList<>();

    public void put(K key, V value) {
        if (data[hash(key)] == null) {
            ArrayList<MyNode<K, V>> myNodes = new ArrayList<>();
            myNodes.add(new MyNode<>(key, value));
            data[hash(key)] = myNodes;
        } else {
            ArrayList<MyNode<K, V>> myNodes = data[hash(key)];
            myNodes.add(new MyNode<>(key, value));
        }
        keySet.add(key);
        entrySet.add(new MyNode<>(key, value));
        values.add(value);
    }

    public V get(K key) {
        for (MyNode<K, V> myNode : data[hash(key)]) {
            if (myNode.getKey().equals(key)) {
                return myNode.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        for (MyNode<K, V> myNode : data[hash(key)]) {
            if (myNode.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void remove(K key) {
        ArrayList<MyNode<K, V>> myNodes = new ArrayList<>();
        for (MyNode<K, V> myNode : data[hash(key)]) {
            if (!myNode.getKey().equals(key)) {
                myNodes.add(myNode);
            }
        }
        data[hash(key)] = myNodes;
    }

    public Set<K> keySet() {
        return keySet;
    }

    public Set<MyNode<K, V>> entrySet() {
        return entrySet;
    }

    public Collection<V> values() {
        return values;
    }

    public int hash(K key) {
        int hash = 0;
        String hashKey = (String) key;
        for (int i = 0; i < hashKey.length(); i++) {
            hash = (hash + hashKey.charAt(i) * i) % length;
        }
        return hash;
    }

    public static void main(String[] args) {
        MyHashTable<String, String> myHashTable = new MyHashTable<>(3);
        myHashTable.put("Ranjith", "Male");
        myHashTable.put("Harshitha", "Female");
        myHashTable.put("Harshith", "Male");
        myHashTable.put("Kousi", "Female");

        System.out.println(myHashTable.get("Ranjith"));
        System.out.println(myHashTable.get("Harshitha"));
        System.out.println(myHashTable.get("Harshith"));
        System.out.println(myHashTable.get("Kousi"));

        myHashTable.remove("Kousi");

        System.out.println(myHashTable.containsKey("Kousi"));

        System.out.println(myHashTable.keySet);
        myHashTable.entrySet.forEach((myNode) -> System.out.println("[" + myNode.getKey() + " , " + myNode.getValue() + "]"));
        System.out.println(myHashTable.values);
    }
}
