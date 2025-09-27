package CoT.claude;

public class Task150 {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class LinkedList {
        Node head;
        
        void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        
        void delete(int data) {
            if (head == null) return;
            
            if (head.data == data) {
                head = head.next;
                return;
            }
            
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }
            
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        
        boolean search(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Test case 1: Insert elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        System.out.println("Search 20: " + list.search(20)); // true
        
        // Test case 2: Delete middle element
        list.delete(20);
        System.out.println("Search 20 after deletion: " + list.search(20)); // false
        
        // Test case 3: Delete first element
        list.delete(10);
        System.out.println("Search 10 after deletion: " + list.search(10)); // false
        
        // Test case 4: Search non-existent element
        System.out.println("Search 40: " + list.search(40)); // false
        
        // Test case 5: Insert after deletion
        list.insert(50);
        System.out.println("Search 50: " + list.search(50)); // true
    }
}
