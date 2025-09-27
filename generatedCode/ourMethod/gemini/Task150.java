package ourMethod.gemini;
class Task150 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }


    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        Node prev = null;
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;
    }

    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Task150 list = new Task150();

        // Test cases
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.printList(); // Output: 10 20 30

        list.delete(20);
        list.printList(); // Output: 10 30

        System.out.println(list.search(30)); // Output: true
        System.out.println(list.search(20)); // Output: false


        list.delete(10);
        list.printList(); // Output: 30

        list.insert(40);
        list.insert(50);
        list.printList(); // Output: 30 40 50

    }
}