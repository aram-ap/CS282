package CircularLinkedList;

public class CircularLinkedList {

    private Node current;
    private int numItems;

    public CircularLinkedList() {
        numItems = 0;
    }

    public int step() {
        if(numItems == 0) {
            System.out.println("Couldn't step, size is 0!");
            return 0;
        }

        current = current.getNext();
        return current.getValue();
    }

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

        current = current.getNext();
        numItems--;

        return deletedNode.getValue();
    }

    public int search(int searchNum) {
        if(numItems == 0) {
            System.out.println("Couldn't search for '" + searchNum + "', size is 0!");
            return 0;
        }

        Node theNode = current;

        for(int i = 0; i < numItems; i++) {
            if(theNode.getValue() == searchNum) {
                return theNode.getValue();
            }
            theNode = theNode.getNext();
        }

        System.out.println("Value '" + searchNum + "' does not exist in the list!");
        return 0;
    }

    public void display() {
        System.out.println(toString());
    }

    public boolean isEmpty() {
        return current == null || numItems == 0;
    }

    public String toString() {
        if(numItems == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node theNode = current;

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
