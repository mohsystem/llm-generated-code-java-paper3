package ourMethod.codestral;
import java.util.ArrayList;
import java.util.List;

class HashTable {
    private class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size;

    public HashTable(int capacity) {
        buckets = new Node[capacity];
        size = 0;
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i)) % buckets.length;
        }
        return hash;
    }

    public void insert(String key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null");
        }
        Node node = new Node(key, value);
        int index = hash(key);
        Node current = buckets[index];
        if (current == null) {
            buckets[index] = node;
        } else {
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = node;
            }
        }
        size++;
    }

    public String search(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

public class Task152 {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert("key1", "value1");
        hashTable.insert("key2", "value2");
        hashTable.insert("key3", "value3");
        System.out.println(hashTable.search("key2")); // value2
        hashTable.delete("key2");
        System.out.println(hashTable.search("key2")); // null
    }
}