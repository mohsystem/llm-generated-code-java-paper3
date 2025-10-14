package ourMethodv2.gpt4o;
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
        private Node head;

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

            if (current.next == null) {
                return false;
            }

            current.next = current.next.next;
            return true;
        }

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
        list.insert(1);
        list.insert(2);
        list.insert(3);
        System.out.println(list.search(2)); // true
        System.out.println(list.delete(2)); // true
        System.out.println(list.search(2)); // false
        list.insert(4);
        list.insert(5);
        System.out.println(list.search(4)); // true
    }
}