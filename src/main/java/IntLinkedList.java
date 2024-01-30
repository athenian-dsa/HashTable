public class IntLinkedList {
    // instance variables
    IntNode head;

    public IntLinkedList()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    // Search the linked list for the specified key
    // return true if key is found, false otherwise
    public boolean search(int key)
    {
        IntNode current = head;

        while (current != null)
        {
            if (current.data == key)
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Insert value to tail of the link list
    public void insert(int data)
    {
        //make a new Node
        IntNode newNode = new IntNode(data);

        // Edge case: list is empty
        if (head == null)
        {
            head = newNode;
            return;
        }
        else
        {
            // find the tail
            IntNode current = head;
            while (current.next != null) {
                current = current.next;
            }

            // point tail to new node
            current.next = newNode;
            return;
        }
    }

    // Delete Node with specified key, returns whether
    // deletion was successful or not
    public boolean delete(int key)
    {
        // Linked list is empty
        if (head == null) {
            return false;
        }
        // If deleting head, need to update head
        else if (head.data == key) {
            head = head.next;
            return true;
        }

        // Otherwise, we are not deleting head, we can proceed as usual
        IntNode prev = head;
        IntNode current = head.next;

        while (current != null)
        {
            // If we found the node, delete it
            if (current.data == key) {
                prev.next = current.next;
                return true;
            }
            else {
                prev = current;
                current = current.next;
            }
        }

        // Else we didn't find the node
        return false;
    }

    // toString function that is called when LinkedList is printed
    public String toString()
    {
        String str = "";
        IntNode current = head;
        while (current != null)
        {
            str = str + current.data + " -> ";
            current = current.next;
        }
        str +=  "null";
        return str;

        // a string representation of your linked list
        // 2 -> 6 -> 17 -> 45
    }
}
