package ourMethod.claude;

public class Task150 {
    private static class Node {
        private int data;
        private Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    
    public Task150() {
        this.head = null;
    }
    
    public void insert(int data) {
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
    
    public boolean delete(int data) {
        if (head == null) {
            return false;
        }
        
        if (head.data == data) {
            head = head.next;
            return true;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }
    
    public boolean search(int data) {
        if (head == null) {
            return false;
        }
        
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Task150 list = new Task150();
        
        // Test case 1: Insert elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        
        // Test case 2: Search existing element
        System.out.println("Search 20: " + list.search(20));  // Should print true
        
        // Test case 3: Search non-existing element
        System.out.println("Search 40: " + list.search(40));  // Should print false
        
        // Test case 4: Delete element
        System.out.println("Delete 20: " + list.delete(20));  // Should print true
        
        // Test case 5: Search deleted element
        System.out.println("Search 20: " + list.search(20));  // Should print false
    }
}
