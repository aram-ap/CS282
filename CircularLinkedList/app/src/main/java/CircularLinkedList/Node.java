package CircularLinkedList;

public class Node {
    private Node next;
    private Node prev;
    private int val;

    public Node(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public int getValue() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }
}
