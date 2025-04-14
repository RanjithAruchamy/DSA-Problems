package data_structures.hash_table;

public class MyNode<K, V> {

    private K key;
    private V value;

    public MyNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
