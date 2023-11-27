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
     * @param data The data to be entered into the linked list
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
     * @param newData The data to be entered into the linked list
     * @param existingData1 One of the data in between which we need to add new data
     * @param existingData2 One of the data in between which we need to add new data
     * @desc Method to add a new node to the LinkedList
     */
    public void insertBetween(T newData, T existingData1, T existingData2) {
        Node<T> newNode = new Node<>(newData);
        Node<T> temp = head;

        while (temp != null) {
            if (temp.data.equals(existingData1) && temp.next != null && temp.next.data.equals(existingData2)) {
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
    public Node<T> search(T value) {
        Node<T> current = head;
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
        linkedList.add(70); //70 is added to linked list

        // Display the elements of the LinkedList.
        linkedList.display();

        System.out.println("Adding 30 in between 56 and 70:");

        // Insert 30 between 56 and 70.
        linkedList.insertBetween(30, 56, 70);

        // Display the elements of the LinkedList.
        linkedList.display();

        // Search for a node with value 30.
        Node<Integer> result = linkedList.search(30);

        if (result != null) {
            System.out.println("Node with value "+result.data+" found.");
        }
        else {
            System.out.println("Node not found.");
        }

    }
}