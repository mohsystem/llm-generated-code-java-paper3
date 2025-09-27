package CoT.claude;

public class Task152 {
    private static class HashNode {
        String key;
        int value;
        HashNode next;
        
        HashNode(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private HashNode[] table;
    private int size;
    private int capacity;
    
    public Task152() {
        capacity = 10;
        size = 0;
        table = new HashNode[capacity];
    }
    
    private int hash(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % capacity);
    }
    
    public void insert(String key, int value) {
        if(key == null) return;
        
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
        size++;
    }
    
    public Integer search(String key) {
        if(key == null) return null;
        
        int index = hash(key);
        HashNode node = table[index];
        
        while(node != null) {
            if(node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    
    public boolean delete(String key) {
        if(key == null) return false;
        
        int index = hash(key);
        HashNode node = table[index];
        HashNode prev = null;
        
        while(node != null) {
            if(node.key.equals(key)) {
                if(prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Task152 hashTable = new Task152();
        
        // Test case 1: Insert and search
        hashTable.insert("one", 1);
        System.out.println("Test 1: " + (hashTable.search("one") == 1));
        
        // Test case 2: Update existing key
        hashTable.insert("one", 10);
        System.out.println("Test 2: " + (hashTable.search("one") == 10));
        
        // Test case 3: Delete existing key
        System.out.println("Test 3: " + hashTable.delete("one"));
        
        // Test case 4: Search non-existing key
        System.out.println("Test 4: " + (hashTable.search("two") == null));
        
        // Test case 5: Delete non-existing key
        System.out.println("Test 5: " + (!hashTable.delete("two")));
    }
}
