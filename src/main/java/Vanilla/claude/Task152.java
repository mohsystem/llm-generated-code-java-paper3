package Vanilla.claude;

class Task152 {
    private static class HashNode {
        String key;
        int value;
        HashNode next;
        
        HashNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int SIZE = 769;
    private HashNode[] table;
    
    public Task152() {
        table = new HashNode[SIZE];
    }
    
    private int hash(String key) {
        int hash = 0;
        for(char c : key.toCharArray()) {
            hash = (hash * 31 + c) % SIZE;
        }
        return hash;
    }
    
    public void insert(String key, int value) {
        int index = hash(key);
        HashNode node = table[index];
        
        while(node != null) {
            if(node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        
        HashNode newNode = new HashNode(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }
    
    public boolean search(String key) {
        int index = hash(key);
        HashNode node = table[index];
        
        while(node != null) {
            if(node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
    
    public void delete(String key) {
        int index = hash(key);
        HashNode node = table[index];
        HashNode prev = null;
        
        while(node != null && !node.key.equals(key)) {
            prev = node;
            node = node.next;
        }
        
        if(node == null) return;
        
        if(prev == null) {
            table[index] = node.next;
        } else {
            prev.next = node.next;
        }
    }
    
    public static void main(String[] args) {
        Task152 hashTable = new Task152();
        
        // Test case 1: Insert and search
        hashTable.insert("apple", 5);
        System.out.println(hashTable.search("apple")); // true
        
        // Test case 2: Insert duplicate
        hashTable.insert("apple", 10);
        hashTable.insert("banana", 7);
        System.out.println(hashTable.search("banana")); // true
        
        // Test case 3: Delete and search
        hashTable.delete("apple");
        System.out.println(hashTable.search("apple")); // false
        
        // Test case 4: Search non-existent
        System.out.println(hashTable.search("orange")); // false
        
        // Test case 5: Multiple operations
        hashTable.insert("grape", 3);
        hashTable.insert("mango", 8);
        hashTable.delete("banana");
        System.out.println(hashTable.search("grape")); // true
        System.out.println(hashTable.search("banana")); // false
    }
}
