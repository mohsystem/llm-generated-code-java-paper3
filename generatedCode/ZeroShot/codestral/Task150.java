package ZeroShot.codestral;
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Task150 {
    Node head;

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
    }

    public void delete(int data) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Task150 list = new Task150();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        System.out.println(list.search(2));
        list.delete(2);
        System.out.println(list.search(2));
    }
}