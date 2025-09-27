package ZeroShot.llama31;
public class Task150 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        // Insert operations
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);

        // Print linked list
        System.out.println("Linked List: ");
        printList(head);

        // Search operation
        System.out.println("Is 3 in the list? " + search(head, 3));

        // Delete operation
        head = deleteNode(head, 3);

        // Print linked list after deletion
        System.out.println("Linked List after deletion: ");
        printList(head);
    }

    public static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static boolean search(Node head, int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    public static Node deleteNode(Node head, int data) {
        if (head == null) return null;

        if (head.data == data) {
            return head.next;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}