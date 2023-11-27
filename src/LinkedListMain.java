import java.util.*;

/**
 *
 * @param <T> the type of data stored in the Node.
 * @desc This class represents a Node in the LinkedList.
 */
class Node<T> {
    T data;
    Node<T> next;

    // Constructor to initialize a Node with data.
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 *
 * @param <T> the type of data stored in the LinkedList.
 * @desc This class represents a LinkedList.
 */
class LinkedList<T> {
    Node<T> head;

    // Constructor to initialize an empty LinkedList.
    public LinkedList() {
        this.head = null;
    }

    /**
     *
     * @param data The data of type T to be entered into the linked list
     * @desc Method to add a new node to the LinkedList
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     *
     * @desc Method to display the elements of the LinkedList.
     */
    public void display() {
        Node<T> current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            if(current.next==null)
                System.out.print(current.data);
            else
                System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }
}

public class LinkedListMain {
    public static void main(String[] args) {
        // Create a LinkedList with elements 56, 30, and 70.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(56); //56 is first added
        linkedList.add(30); //30 is added to linked list
        linkedList.add(70); //70 is added to linked list

        // Display the elements of the LinkedList.
        linkedList.display();

    }
}