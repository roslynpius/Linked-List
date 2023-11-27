/**
 * This class represents a Node in the LinkedList.
 *
 * @param <T> the type of data stored in the Node (must be Comparable).
 */
class Node<T extends Comparable<T>> {
    T data;
    Node<T> next;

    // Constructor to initialize a Node with data.
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * This class represents an OrderedLinkedList.
 *
 * @param <T> the type of data stored in the LinkedList (must be Comparable).
 */
class OrderedLinkedList<T extends Comparable<T>> {
    Node<T> head;

    // Constructor to initialize an empty OrderedLinkedList.
    public OrderedLinkedList() {
        this.head = null;
    }

    // Method to add a new node to the OrderedLinkedList in ascending order.
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null || head.data.compareTo(data) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null && temp.next.data.compareTo(data) < 0) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        System.out.println(data+" added.");
    }

    // Method to display the elements of the OrderedLinkedList.
    public void display() {
        Node<T> current = head;
        System.out.print("OrderedLinkedList Sequence: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class LinkedListMain {
    public static void main(String[] args) {
        // Create an OrderedLinkedList with elements 56, 30, 40, and 70.
        OrderedLinkedList<Integer> orderedLinkedList = new OrderedLinkedList<>();
        orderedLinkedList.add(56);
        orderedLinkedList.add(30);
        orderedLinkedList.add(40);
        orderedLinkedList.add(70);

        // Display the final ordered sequence.
        orderedLinkedList.display();
    }
}
