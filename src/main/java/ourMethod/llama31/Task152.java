package ourMethod.llama31;
public class Task152 {
    static class HashTable {
        private int size;
        private Node[] table;

        public HashTable(int size) {
            this.size = size;
            table = new Node[size];
        }

        private int hashFunction(int key) {
            return key % size;
        }

        public void insert(int key, int value) {
            int index = hashFunction(key);
            if (table[index] == null) {
                table[index] = new Node(key, value);
            } else {
                Node node = table[index];
                while (node.next != null) {
                    if (node.key == key) {
                        node.value = value;
                        return;
                    }
                    node = node.next;
                }
                if (node.key == key) {
                    node.value = value;
                } else {
                    node.next = new Node(key, value);
                }
            }
        }

        public void delete(int key) {
            int index = hashFunction(key);
            if (table[index] == null) return;
            if (table[index].key == key) {
                table[index] = table[index].next;
                return;
            }
            Node node = table[index];
            while (node.next != null) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }

        public int search(int key) {
            int index = hashFunction(key);
            if (table[index] == null) return -1;
            Node node = table[index];
            while (node != null) {
                if (node.key == key) return node.value;
                node = node.next;
            }
            return -1;
        }

        private class Node {
            int key;
            int value;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        public void display() {
            for (int i = 0; i < size; i++) {
                System.out.print("Index " + i + ": ");
                Node node = table[i];
                while (node != null) {
                    System.out.print(node.key + " -> " + node.value + " ");
                    node = node.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert(1, 10);
        hashTable.insert(2, 20);
        hashTable.insert(11, 30); // Collision
        hashTable.display();
        System.out.println("Search for key 1: " + hashTable.search(1));
        hashTable.delete(2);
        hashTable.display();
    }
}