package HashtableAssignment;

/*
 *
 * @author juneja_u
 */
public class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(){

    }
    public Node(int data){
        this.data = data;
    }
    public String toString(){
        return data+ " ";
    }
}

