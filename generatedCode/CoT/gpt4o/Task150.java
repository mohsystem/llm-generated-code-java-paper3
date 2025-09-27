package CoT.gpt4o;
public class Task150 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;

        // Insert a new node with given data
        public void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Delete a node with given data
        public boolean delete(int data) {
            if (head == null) return false;
            if (head.data == data) {
                head = head.next;
                return true;
            }
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }
            if (current.next == null) return false;
            current.next = current.next.next;
            return true;
        }

        // Search for a node with given data
        public boolean search(int data) {
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
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println(list.search(30)); // true
        System.out.println(list.delete(20)); // true
        System.out.println(list.search(20)); // false
        System.out.println(list.search(10)); // true
        System.out.println(list.delete(50)); // true
    }
}