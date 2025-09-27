package CoT.llama31;
public class Task150 {

    // Node class to represent a node of the linked list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Linked list class
    static class LinkedList {
        Node head;

        // Insert at the beginning of the linked list
        public void insertAtHead(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        // Insert at the end of the linked list
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }

        // Delete a node with the given data
        public void deleteNode(int data) {
            if (head == null) return;

            if (head.data == data) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }

        // Search for a node with the given data
        public boolean searchNode(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data) {
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
        linkedList.insertAtHead(1);
        linkedList.insertAtHead(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);

        System.out.println("Linked List: ");
        linkedList.printList();

        System.out.println("Search for 2: " + linkedList.searchNode(2));
        System.out.println("Search for 5: " + linkedList.searchNode(5));

        linkedList.deleteNode(2);
        System.out.println("After deleting 2: ");
        linkedList.printList();
    }
}