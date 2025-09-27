package Vanilla.gpt4o;
class Task150 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static class SinglyLinkedList {
        Node head;

        void insert(int data) {
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

        boolean delete(int data) {
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

        boolean search(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data) return true;
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
        System.out.println(list.search(20)); // true
        System.out.println(list.delete(20)); // true
        System.out.println(list.search(20)); // false
        System.out.println(list.delete(40)); // false
        System.out.println(list.search(10)); // true
    }
}