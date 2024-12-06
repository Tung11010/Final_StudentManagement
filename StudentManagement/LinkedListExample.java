
class Node {
    int data; 
    Node next; 

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head; 

    public void add(int data) {
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

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void delete(int value) {
        if (head == null) return; 

        if (head.data == value) {
            head = head.next; 
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next; 
        }
    }
}

// Main class
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Linked List:");
        list.display();

        list.delete(20);
        System.out.println("After deleting 20:");
        list.display();

        
        list.delete(10);
        System.out.println("After deleting 10:");
        list.display();
    }
}
