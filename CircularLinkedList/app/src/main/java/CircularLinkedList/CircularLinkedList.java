package CircularLinkedList;

/**
 * A circular linked list is a list of values connected such that there is no "head" or "tail"
 */
public class CircularLinkedList {

    private Node current;
    private int numItems;

    public CircularLinkedList() {
        numItems = 0;
    }

    /**
     * Steps forward to the next node
     * @return value of the new current node
     */
    public int step() {
        if(numItems == 0) {
            System.out.println("Couldn't step, size is 0!");
            return 0;
        }

        current = current.getNext();
        return current.getValue();
    }

    /**
     * Inserts a new value in front of the current node
     * @param val The number to insert
     */
    public void insert(int val) {
        Node node = new Node(val);

        if(current == null) {
            node.setNext(node);
            node.setPrev(node);
        } else {
            node.setNext(current.getNext());
            node.setPrev(current);
            current.setNext(node);
        }

        current = node;
        numItems++;
    }

    /**
     * Deletes the current node
     * @return The value of the deleted node
     */
    public int delete() {
        if(numItems == 0) {
            System.out.println("Couldn't delete, size is 0!");
            return 0;
        } else if (numItems == 0) {
            Node lastNode = current;
            current = null;
            return lastNode.getValue();
        }

        Node deletedNode = current;

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());

        current = current.getPrev();
        numItems--;

        return deletedNode.getValue();
    }

    /**
     * Searches for the specified value in the list
     * @param searchNum The number to search for
     * @return Returns the given searchNum if found, -1 if not.
     */
    public int search(int searchNum) {
        if(numItems == 0) {
            System.out.println("Couldn't search for '" + searchNum + "', size is 0!");
            return -1;
        }

        Node theNode = current;

        for(int i = 0; i < numItems; i++) {
            if(theNode.getValue() == searchNum) {
                return theNode.getValue();
            }
            theNode = theNode.getNext();
        }

        System.out.println("Value '" + searchNum + "' does not exist in the list!");
        return -1;
    }

    /**
     * Prints the contents of the list
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * @return true if the list has no elements
     */
    public boolean isEmpty() {
        return current == null || numItems == 0;
    }

    public String toString() {
        if(numItems == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node theNode = current.getNext();

        for(int i = 0; i < numItems; i++) {
            int val = theNode.getValue();
            sb.append(val);

            if(i != numItems - 1) {
                sb.append(", ");
            }
            theNode = theNode.getNext();
        }
        sb.append("]");
        sb.append("\nCurrent Node: " + current.getValue());

        return sb.toString();
    }
}
