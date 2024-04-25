package TwoThreeFour;
/**
 *
 * @author juneja_u
 */
public class Tree234 {
    Node root;

    public Tree234(){
        root = new Node();
    }

    public int search(int key){
       Node curr = root;
       while(true){
           int index = curr.findItem(key);
           if(index != -1) //found
               return index;
           else if(curr.isLeaf()) //not found
               return -1;
           else //i dont know, have to check further down
              curr = getNextLevel(curr, key);
       }
    }

    public Node getNextLevel(Node curr, int key){
        //figure out what child to go to
        int i;
        for(i = 0; i < curr.numOfItems ; i++){
            if(key < curr.data[i])
                return curr.getChild(i);
        }
        return curr.getChild(i);
    }
    public void insert(int item){
        Node curr = root;
        while(true){
            if(curr.isFull()){
                split(curr);
                curr = curr.parent;
                curr = getNextLevel(curr, item);
            }
            else if(curr.isLeaf())
                break;
            else
                curr = getNextLevel(curr, item);

        }
        curr.insertItem(item);
    }
    public void split(Node curr){
        int C = curr.removeItem();
        int B = curr.removeItem();
        Node parent;
        Node sibling = new Node();
        sibling.insertItem(C);

        if(curr == root){
            root = new Node();
            parent = root;
            //parent.insertItem(B);
            root.connectChild(curr, 0);
        }
        else
            parent = curr.parent;

        //deal with parent
        int index = parent.insertItem(B);
        int n = parent.numOfItems;
        for(int i = n-1; i > index; i--){
            Node temp = parent.disconnectChild(i);
            parent.connectChild(temp, i+1);
        }
        parent.connectChild(sibling, index+1);
        Node child2 = curr.disconnectChild(2);
        Node child3 = curr.disconnectChild(3);
        sibling.connectChild(child2, 0);
        sibling.connectChild(child3, 1);
    }


    //Deletes the node which contains the key
    public Node delete(int key) {
       Node curr = root;
       int index;
       while(true){
           index = curr.findItem(key);
           if(index != -1) //found
               break;
           else if(curr.isLeaf()) //not found
               return null;
           else //i dont know, have to check further down
              curr = getNextLevel(curr, key);
       }

       curr.isDeleted = true;
       return curr;
    }


    public void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    private void inorderTraversalRecursive(Node node) {
        if(node == null) {
            return;
        } else {
            //print A
            inorderTraversalRecursive(node.getChild(0));
            node.displayNode();

            //print B
            inorderTraversalRecursive(node.getChild(1));

            //print C
            inorderTraversalRecursive(node.getChild(2));
        }
    }
}

