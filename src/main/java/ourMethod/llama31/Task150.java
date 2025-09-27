package ourMethod.llama31;
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

    // LinkedList class
    static class LinkedList {
        Node head;

        // Insert at the beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        // Insert at the end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newNode;
            }
        }

        // Delete a node
        public void deleteNode(int key) {
            if (head == null) return;

            if (head.data == key) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.data == key) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }

        // Search for a node
        public boolean searchNode(int key) {
            Node current = head;
            while (current != null) {
                if (current.data == key) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // Print the linked list
        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Test cases
        linkedList.insertAtBeginning(10);
        linkedList.insertAtBeginning(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);

        System.out.println("Linked List: ");
        linkedList.printList();

        System.out.println("Search for 20: " + linkedList.searchNode(20));
        System.out.println("Search for 50: " + linkedList.searchNode(50));

        linkedList.deleteNode(20);

        System.out.println("Linked List after deletion: ");
        linkedList.printList();
    }
}