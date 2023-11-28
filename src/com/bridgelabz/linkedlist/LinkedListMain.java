package com.bridgelabz.linkedlist;

/**
 * This class represents a Node in the OrderedLinkedList.
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
 * This class represents a Node in the LinkedList.
 *
 * @param <T> the type of data stored in the Node (must be Comparable).
 */
class Node2<T> {
    T data;
    Node2<T> next;

    // Constructor to initialize a Node with data.
    public Node2(T data) {
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
    Node2<T> head;

    // Constructor to initialize an empty LinkedList.
    public LinkedList() {
        this.head = null;
    }

    /**
     *
     * @param data The data to be entered into the linked list
     * @desc Method to add a new node to the LinkedList
     */
    public void add(T data) {
        Node2<T> newNode = new Node2<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node2<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     *
     * @param newData The data to be entered into the linked list
     * @param existingData1 One of the data in between which we need to add new data
     * @desc Method to add a new node to the LinkedList
     */
    public void insertAfter(T newData, T existingData1) {
        Node2<T> newNode = new Node2<>(newData);
        Node2<T> temp = head;

        while (temp != null) {
            if (temp.data.equals(existingData1)) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     *
     * @param value the value to be searched
     * @desc Method to search for an element in the LinkedList.
     * @return Returns the node if element is found else null
     */
    public Node2<T> search(T value) {
        Node2<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     *
     * @param value : Element to be deleted
     * @desc Method to delete particular element
     */
    public void pop(T value) {
        Node2<T> current = head;
        Node2<T> prev = null;

        if(value.equals(head.data)) {
            head = head.next;
            return;
        }

        while(current!=null)
        {
            if(value.equals(current.data))
            {
                assert prev != null;
                prev.next=current.next;
                break;
            }
            prev=current;
            current=current.next;
        }
    }

    /**
     *
     * @desc Method to display the elements of the LinkedList.
     */
    public void display() {
        Node2<T> current = head;
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

    /**
     *
     * @param data The data to be added
     * @desc Method to add a new node to the OrderedLinkedList in ascending order.
     */
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
        System.out.print("Ordered LinkedList Sequence: ");
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

        // Create a LinkedList with elements 56, 30, and 70.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(56); //56 is first added
        linkedList.add(30); // 30 is added to linked list
        linkedList.add(70); //70 is added to linked list

        // Display the elements of the LinkedList.
        linkedList.display();

        // Insert 40 after 30.
        System.out.println("Adding 40 after 30:");
        linkedList.insertAfter(40, 30);

        // Display the elements of the LinkedList.
        linkedList.display();

        // Search for a node with value 30.
        System.out.println("Searching for value 40:");
        Node2<Integer> result = linkedList.search(40);

        if (result != null) {
            System.out.println("Node with value "+result.data+" found.");

            //delete 40
            System.out.println("After deleting 40:");
            linkedList.pop(40);
            linkedList.display();
        }
        else {
            System.out.println("Node not found.");
        }

        // Create an OrderedLinkedList with elements 56, 30, 40, and 70.
        OrderedLinkedList<Integer> orderedLinkedList = new OrderedLinkedList<>();
        orderedLinkedList.add(56);
        orderedLinkedList.add(30);
        orderedLinkedList.add(40);
        orderedLinkedList.add(70);

        // Display the final ordered sequence.
        System.out.println();
        System.out.println("Ordered Linked List");
        orderedLinkedList.display();
    }
}
