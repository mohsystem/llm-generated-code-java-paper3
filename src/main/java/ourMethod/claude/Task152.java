package ourMethod.claude;

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

    private static class HashTable {
        private HashNode[] buckets;
        private int size;
        private static final int INITIAL_CAPACITY = 16;
        private static final double LOAD_FACTOR = 0.75;

        public HashTable() {
            this.buckets = new HashNode[INITIAL_CAPACITY];
            this.size = 0;
        }

        private int getBucketIndex(String key) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }
            int hashCode = key.hashCode();
            return Math.abs(hashCode % buckets.length);
        }

        public void insert(String key, int value) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }
            
            if ((double)size / buckets.length >= LOAD_FACTOR) {
                resize();
            }

            int bucketIndex = getBucketIndex(key);
            HashNode head = buckets[bucketIndex];
            
            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            HashNode newNode = new HashNode(key, value);
            newNode.next = buckets[bucketIndex];
            buckets[bucketIndex] = newNode;
            size++;
        }

        public Integer search(String key) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }

            int bucketIndex = getBucketIndex(key);
            HashNode head = buckets[bucketIndex];

            while (head != null) {
                if (head.key.equals(key)) {
                    return head.value;
                }
                head = head.next;
            }
            return null;
        }

        public boolean delete(String key) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }

            int bucketIndex = getBucketIndex(key);
            HashNode head = buckets[bucketIndex];
            HashNode prev = null;

            while (head != null) {
                if (head.key.equals(key)) {
                    if (prev == null) {
                        buckets[bucketIndex] = head.next;
                    } else {
                        prev.next = head.next;
                    }
                    size--;
                    return true;
                }
                prev = head;
                head = head.next;
            }
            return false;
        }

        private void resize() {
            HashNode[] oldBuckets = buckets;
            buckets = new HashNode[oldBuckets.length * 2];
            size = 0;

            for (HashNode head : oldBuckets) {
                while (head != null) {
                    insert(head.key, head.value);
                    head = head.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        HashTable table = new HashTable();
        
        // Test case 1: Insert and search
        table.insert("one", 1);
        System.out.println("Test 1: " + (table.search("one") == 1));

        // Test case 2: Update existing key
        table.insert("one", 2);
        System.out.println("Test 2: " + (table.search("one") == 2));

        // Test case 3: Delete existing key
        System.out.println("Test 3: " + table.delete("one"));

        // Test case 4: Search non-existent key
        System.out.println("Test 4: " + (table.search("one") == null));

        // Test case 5: Delete non-existent key
        System.out.println("Test 5: " + (!table.delete("one")));
    }
}
