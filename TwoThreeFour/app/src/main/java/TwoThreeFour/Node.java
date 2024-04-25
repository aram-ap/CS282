
package TwoThreeFour;
/**
 *
 * @author juneja_u
 */
public class Node {
    int[] data;
    Node[] children;
    int numOfItems;
    Node parent;
    boolean isDeleted = false;

    public Node(){
        data = new int[3];
        children = new Node[4];
    }

    public boolean isLeaf(){
        return children[0] == null;
    }

    public boolean isFull(){
        return numOfItems == 3;
    }

    public int findItem(int key){
        if(isDeleted)
            return -1;

        for(int i = 0 ; i < data.length ; i++){
            if(data[i] == key)
                return i;
        }
        return -1;
    }

    public int insertItem(int item){
        //assumes that the node is not full
        //numOfItems++;
        for(int i = numOfItems-1 ; i >= 0 ; i--){
            if(data[i] > item)
                data[i+1] = data[i];
            else{
                data[i+1] = item;
                numOfItems++;
                return i+1;
            }
        }
        data[0] = item;
        numOfItems++;
        return 0;
    }
    public int removeItem(){
        //assume that the node is not empty
        //remove the largest item
        int temp = data[numOfItems-1];
        data[numOfItems -1] = 0;
        numOfItems--;
        return temp;
    }
    public void connectChild(Node child, int index){
        children[index] = child;
        if(child != null)
            child.parent = this;
    }
    public Node disconnectChild(int index){
        Node temp = children[index];
        children[index] = null;
        return temp;
    }
    public Node getChild(int index){
        return children[index];
    }
    public void displayNode() {
        if(isDeleted) {
            return;
        }

        for(int i = 0 ; i < numOfItems ; i++){
            System.out.print(data[i] + " ");
        }
    }
}

