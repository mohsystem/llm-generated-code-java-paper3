package ZeroShot.claude;

class Task152 {
    static class HashNode {
        String key;
        int value;
        HashNode next;
        
        HashNode(String key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    
    static class HashTable {
        private HashNode[] buckets;
        private int size;
        private int capacity;
        
        public HashTable(int capacity) {
            this.capacity = capacity;
            buckets = new HashNode[capacity];
            size = 0;
        }
        
        private int hashFunction(String key) {
            int hash = 0;
            for(char c : key.toCharArray()) {
                hash = (hash * 31 + c) % capacity;
            }
            return Math.abs(hash % capacity);
        }
        
        public void insert(String key, int value) {
            int index = hashFunction(key);
            HashNode node = buckets[index];
            
            while(node != null) {
                if(node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            
            HashNode newNode = new HashNode(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
        }
        
        public boolean delete(String key) {
            int index = hashFunction(key);
            HashNode node = buckets[index];
            HashNode prev = null;
            
            while(node != null) {
                if(node.key.equals(key)) {
                    if(prev == null) {
                        buckets[index] = node.next;
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
        
        public Integer search(String key) {
            int index = hashFunction(key);
            HashNode node = buckets[index];
            
            while(node != null) {
                if(node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        
        // Test case 1: Insert and search
        ht.insert("apple", 5);
        System.out.println("Search apple: " + ht.search("apple")); // Should print 5
        
        // Test case 2: Update existing key
        ht.insert("apple", 10);
        System.out.println("Search apple after update: " + ht.search("apple")); // Should print 10
        
        // Test case 3: Search non-existent key
        System.out.println("Search banana: " + ht.search("banana")); // Should print null
        
        // Test case 4: Delete existing key
        System.out.println("Delete apple: " + ht.delete("apple")); // Should print true
        
        // Test case 5: Delete non-existent key
        System.out.println("Delete banana: " + ht.delete("banana")); // Should print false
    }
}
