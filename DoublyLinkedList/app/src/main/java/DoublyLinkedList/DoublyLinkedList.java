package DoublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() { }

    public void insertFirst(int val) {

    }

    public void insertLast(int val) {

    }

    public int deleteFirst() {
        return 0;
    }

    public int deleteLast() {
        return 0;
    }

    public void insertAfter(int item, int key) {
        Node curr = head;

        while(curr.data != item) {
            curr = curr.next;
            if(curr == null) {
                return;
            }
        }

        Node n = new Node(key);
        if(curr == tail) {
            insertLast(key);
        }
        else {
            n.next = curr.next;
            curr.next.prev = n;
            n.prev = curr;
            curr.next = n;
        }
    }

    public Node delete(int item) {
        Node curr = head;
        while(curr.data != item) {
            curr = curr.next;
            if(curr == null)
                return null;
        }
        //found item to be deleted

        if(curr == head) {
            deleteFirst();
        }
        else if (curr == tail) {
            deleteLast();
        }
        return null;
    }

    public void display() {
        Node curr = head;
        StringBuilder sb = new StringBuilder("[");

        while(curr != null) {
            int val = curr.data;
            if(curr.next != null)
                sb.append(val + ", ");
            curr = curr.next;
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    public void displayBackwards() {
        Node curr = tail;
        StringBuilder sb = new StringBuilder("[");

        while(curr != null) {
            int val = curr.data;
            if(curr.prev != null)
                sb.append(val + ", ");
            head = head.prev;
        }

        sb.append("]");
        System.out.println(sb.toString());
    }
}
