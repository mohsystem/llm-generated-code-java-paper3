package Vanilla.claude;

class Task150 {
    static class Node {
        int data;
        Node next;
        
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    static class LinkedList {
        Node head;
        
        void insert(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        
        void delete(int key) {
            Node temp = head, prev = null;
            
            if (temp != null && temp.data == key) {
                head = temp.next;
                return;
            }
            
            while (temp != null && temp.data != key) {
                prev = temp;
                temp = temp.next;
            }
            
            if (temp == null) return;
            prev.next = temp.next;
        }
        
        boolean search(int key) {
            Node current = head;
            while (current != null) {
                if (current.data == key)
                    return true;
                current = current.next;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Test Case 1: Insert elements
        list.insert(1);
        list.insert(2);
        list.insert(3);
        
        // Test Case 2: Search existing element
        System.out.println("Search 2: " + list.search(2));
        
        // Test Case 3: Search non-existing element
        System.out.println("Search 4: " + list.search(4));
        
        // Test Case 4: Delete element
        list.delete(2);
        System.out.println("Search after delete 2: " + list.search(2));
        
        // Test Case 5: Insert after delete
        list.insert(4);
        System.out.println("Search 4 after insert: " + list.search(4));
    }
}
