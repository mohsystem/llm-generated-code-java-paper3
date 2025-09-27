package Vanilla.llama31;
public class Task150 {
    // Node class
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to insert at the beginning
    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        return newNode;
    }

    // Function to insert at the end
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return head;
    }

    // Function to delete a node
    public static Node deleteNode(Node head, int key) {
        if (head == null) return null;
        if (head.data == key) {
            return head.next;
        }
        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
        return head;
    }

    // Function to search for a node
    public static boolean searchNode(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Function to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;

        // Test cases
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 7);

        System.out.println("Created Linked List: ");
        printList(head);

        head = insertAtBeginning(head, 1);
        System.out.println("Linked List after insertion at beginning: ");
        printList(head);

        head = deleteNode(head, 3);
        System.out.println("Linked List after deletion of 3: ");
        printList(head);

        System.out.println("Is 5 in the list? " + searchNode(head, 5));
        System.out.println("Is 3 in the list? " + searchNode(head, 3));
    }
}