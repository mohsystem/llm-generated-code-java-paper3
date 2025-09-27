package ZeroShot.claude;

class Task150 {
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
        
        boolean delete(int data) {
            if(head == null) return false;
            
            if(head.data == data) {
                head = head.next;
                return true;
            }
            
            Node current = head;
            while(current.next != null) {
                if(current.next.data == data) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        }
        
        boolean search(int data) {
            Node current = head;
            while(current != null) {
                if(current.data == data) {
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
        System.out.println("Search 20: " + list.search(20)); // Should print true
        
        // Test case 2: Search non-existent element
        System.out.println("Search 40: " + list.search(40)); // Should print false
        
        // Test case 3: Delete existing element
        System.out.println("Delete 20: " + list.delete(20)); // Should print true
        
        // Test case 4: Delete non-existent element
        System.out.println("Delete 40: " + list.delete(40)); // Should print false
        
        // Test case 5: Search after deletion
        System.out.println("Search 20 after deletion: " + list.search(20)); // Should print false
    }
}
