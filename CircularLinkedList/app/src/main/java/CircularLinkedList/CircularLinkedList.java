package CircularLinkedList;

/**
 * A circular linked list is a list of values connected such that there is no "head" or "tail"
 * @author Aram Aprahamian
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
        } else {
            node.setNext(current.getNext());
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

        Node deletedNode = current.getNext();
        current.setNext(deletedNode.getNext());

        numItems--;
        return deletedNode.getValue();
    }

    /**
     * Searches for the specified value in the list.
     * @param searchNum The number to search for.
     * @return True if {@code searchNum} is found in the list, False if not.
     */
    public boolean search(int searchNum) {
        if(numItems == 0) {
            System.out.println("Couldn't search for '" + searchNum + "', size is 0!");
            return false;
        }


        for(int i = 0; i < size(); i++) {
            if(current.getValue() == searchNum) {
                return true;
            }
            step();
        }

        System.out.println("Value '" + searchNum + "' does not exist in the list!");
        return false;
    }

    /**
     * @return the current node's value, returns 0 if the list is empty
     */
    public int getCurrent() {
        if(isEmpty()) {
            return 0;
        }

        return current.getValue();
    }

    /**
     * Prints the contents of the list
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * @return a clone of the list, does not return null
     */
    public CircularLinkedList clone() {
        var list = new CircularLinkedList();
        if(isEmpty()){
            return list;
        }

        for(int i = 0; i < size(); i++) {
            step();
            int val = current.getValue();
            list.insert(val);
        }

        return list;
    }

    /**
     * @return true if the list has no elements
     */
    public boolean isEmpty() {
        return current == null || numItems == 0;
    }

    /**
     * @return the number of elements contained in the list
     */
    public int size() {
        return numItems;
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

    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof CircularLinkedList cll)) {
            return false;
        } else if (cll.isEmpty() && isEmpty()) {
            return true;
        } else if(cll.numItems != numItems) {
            return false;
        }

        //Search both to the same value ensures both start at the correct starting point
        cll.search(current.getValue());
        search(current.getValue());

        for(int i = 0; i < numItems; i++) {
            if(cll.step() != step()) {
                return false;
            }
        }

        return true;
    }
}
