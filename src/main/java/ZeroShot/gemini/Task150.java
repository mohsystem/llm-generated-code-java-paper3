package ZeroShot.gemini;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Task150 {
    Node head;

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

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        prev.next = current.next;
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

    public static void main(String[] args) {
        Task150 list = new Task150();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        System.out.println(list.search(20)); // true
        System.out.println(list.search(40)); // false
        list.delete(20);
        System.out.println(list.search(20)); // false
        list.insert(40);
        list.delete(10);
         System.out.println(list.search(10)); // false
        System.out.println(list.search(40)); // true

    }
}