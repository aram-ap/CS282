package HashtableAssignment;

/*
 *
 * @author juneja_u
 */
public class Node {
    Student data;
    Node leftChild;
    Node rightChild;

    public Node(){

    }
    public Node(Student data){
        this.data = data;
    }
    public String toString(){
        return data+ " ";
    }
}

