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
     * @desc Method to add a new node to the LinkedList
     */
    public void insertAfter(T newData, T existingData1) {
        Node<T> newNode = new Node<>(newData);
        Node<T> temp = head;

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
     * @param value : Element to be deleted
     * @desc Method to delete particular element
     */
    public void pop(T value) {
        Node<T> current = head;
        Node<T> prev = null;

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
        Node<Integer> result = linkedList.search(40);

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

    }
}