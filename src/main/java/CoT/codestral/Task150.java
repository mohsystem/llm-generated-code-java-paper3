package CoT.codestral;
// Node class
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// LinkedList class
class LinkedList {
    Node head;

    // Insert a new node at the beginning
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Delete a node with given key
    public void delete(int key) {
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // Search for the key to be deleted
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    // Search a node with given key
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.insert(1);
        llist.insert(2);
        llist.insert(3);

        System.out.println("Linked List:");
        llist.printList();

        System.out.println("\nSearch for 2: " + llist.search(2));

        llist.delete(2);
        System.out.println("\nLinked List after deleting 2:");
        llist.printList();
    }

    // Utility function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}